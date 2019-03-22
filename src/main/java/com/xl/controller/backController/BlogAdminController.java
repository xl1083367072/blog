package com.xl.controller.backController;

import com.alibaba.fastjson.JSONObject;
import com.xl.pojo.Blog;
import com.xl.service.BlogService;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 操作博客信息
 */
@Controller
@RequestMapping("/admin")
public class BlogAdminController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private HttpSolrServer solrServer;

    @ResponseBody
    @RequestMapping("/save")
    public String save(Blog blog){
        blog.setRelease_date(new Date());
//        返回添加的博客的id
        int id = blogService.save(blog);
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id",id);
        doc.addField("blog_title",blog.getTitle());
        doc.addField("blog_content",blog.getContent());
        doc.addField("blog_summary",blog.getSummary());
        doc.addField("release_date",blog.getRelease_date());
        JSONObject jsonObject = new JSONObject();
        try {
            solrServer.add(doc);
            solrServer.commit();
            jsonObject.put("success",true);
        }catch (Exception e){
            jsonObject.put("success",false);
            e.printStackTrace();
        }
        return jsonObject.toJSONString();
    }

}
