package com.xl.controller.backController;

import com.alibaba.fastjson.JSONObject;
import com.xl.pojo.Blog;
import com.xl.pojo.BlogType;
import com.xl.service.BlogService;
import com.xl.service.BlogTypeService;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

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

    @Autowired
    private BlogTypeService blogTypeService;

    @ResponseBody
    @RequestMapping("/saveBlog")
    public String save(Blog blog){
        blog.setRelease_date(new Date());
//        返回添加的博客的id
        int count = blogService.save(blog);
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id",blog.getId());
        doc.addField("blog_title",blog.getTitle());
        doc.addField("blog_content",blog.getContent());
        doc.addField("blog_summary",blog.getSummary());
        doc.addField("release_date",blog.getRelease_date());
        JSONObject jsonObject = new JSONObject();
        try {
            solrServer.add(doc);
            solrServer.commit();
            if(count>0)
                jsonObject.put("success", true);
            else
                jsonObject.put("success", false);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/blogList")
    public List<Blog> blogList(){
        List<Blog> blogs = blogService.findAll();
        for (Blog blog : blogs){
            BlogType blogType = blogTypeService.findById(blog.getType_id());
            blog.setBlogType(blogType);
        }
        return blogs;
    }

    @ResponseBody
    @RequestMapping("/findById")
    public Blog modifyBlog(Integer id){

        Blog blog = blogService.findById(id);
        BlogType blogType = blogTypeService.findById(blog.getType_id());
        blog.setBlogType(blogType);

        return  blog;
    }


}
