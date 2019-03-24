package com.xl.controller.backController;

import com.alibaba.fastjson.JSONObject;
import com.xl.pojo.Blog;
import com.xl.pojo.BlogType;
import com.xl.service.BlogService;
import com.xl.service.BlogTypeService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    @Autowired
    private SimpleDateFormat dateFormat;

    @ResponseBody
    @RequestMapping("/saveBlog")
    public String save(Blog blog,HttpServletRequest request){
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
//        该类型博客数量加1

        refresh(request);
        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/blogList")
    public List<Blog> blogList(String title) throws Exception{
        List<Blog> blogs = null;
        if(title!=null&&!title.equals("")){
            blogs = new ArrayList<>();
//            solrj关键字搜索
            SolrQuery query = new SolrQuery();
//            设置搜索关键字
            query.setQuery(title);
//            设置查找域
            query.set("df","blog_title");
//            设置分页
            query.setStart(0);
            query.setRows(10);
//            获得查询结果集
            QueryResponse queryResponse = solrServer.query(query);
            SolrDocumentList solrDocuments = queryResponse.getResults();
//            遍历结果集
            for (SolrDocument doc:solrDocuments) {
                Blog blog = new Blog();
//                设置属性
                blog.setId(Integer.parseInt((String)(doc.get("id"))));
                blog.setTitle((String) doc.get("blog_title"));
                String releaseDateStr = dateFormat.format(doc.get("release_date"));
                blog.setReleaseDateStr(releaseDateStr);
                BlogType blogType = blogTypeService.findById((Integer) doc.get("blogType"));
                blog.setBlogType(blogType);
                blogs.add(blog);
            }

        }else {
            blogs = blogService.findAll();
            for (Blog blog : blogs){
                BlogType blogType = blogTypeService.findById(blog.getType_id());
                blog.setBlogType(blogType);
                String releaseDateStr = dateFormat.format(blog.getRelease_date());
                blog.setReleaseDateStr(releaseDateStr);
            }
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

    @ResponseBody
    @RequestMapping("/removeBlog")
    public String removeBlog(String ids,HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();
        if(ids!=null&&ids.length()>0){
            String[] split = ids.split(",");
            for (String id:split) {
//                删除索引和数据库中的数据
                solrServer.deleteById(id);
                blogService.removeBlogById(Integer.parseInt(id));
            }
            solrServer.commit();
            jsonObject.put("success",true);
        }
        refresh(request);
        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/modifyBlog")
    public String modifyBlog(Blog blog,HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();

        if(blog!=null){
            blogService.modify(blog);
            jsonObject.put("success",true);
        }
        return  jsonObject.toJSONString();
    }

    public void refresh(HttpServletRequest request){
        List<BlogType> blogTypes = blogTypeService.countList();
        request.getServletContext().setAttribute("blogTypeCountList",blogTypes);
    }

}
