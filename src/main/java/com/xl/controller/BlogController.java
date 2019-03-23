package com.xl.controller;

import com.xl.pojo.Blog;
import com.xl.pojo.BlogType;
import com.xl.pojo.Comment;
import com.xl.service.BlogService;
import com.xl.service.BlogTypeService;
import com.xl.service.CommentService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 博客控制器
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    private static final int PAGESIZE = 10;

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogTypeService blogTypeService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private HttpSolrServer solrServer;

    @RequestMapping("/articles/{id}")
    public String getArticles(@PathVariable("id") Integer id, Model model, HttpServletRequest request){

//        博客和博客类型信息
        Blog blog = blogService.findById(id);
        BlogType blogType = blogTypeService.findByBlogId(id);
        blog.setBlogType(blogType);
        Integer click_hit = blog.getClick_hit();
//        点击数增加
        click_hit = click_hit==null?0:click_hit+1;
        blog.setClick_hit(click_hit);
        blogService.update(blog);
        model.addAttribute("blog",blog);

//        博客的关键字信息
        String keyWord = blog.getKey_word();
        List<String> key = new ArrayList<>();
        if(keyWord!=null){
            String[] keyWords = keyWord.split(" ");
            key.addAll(Arrays.asList(keyWords));
        }
        model.addAttribute("keyWords",key);
//        获得上下篇博客信息
        Blog lastBlog = blogService.lastBlog(id);
        Blog nextBlog = blogService.nextBlog(id);
        model.addAttribute("lastBlog",lastBlog);
        model.addAttribute("nextBlog",nextBlog);

//        获得评论信息
        List<Comment> comments = commentService.findCommentByBlogId(id);
        model.addAttribute("commentList",comments);


//        让主页显示博客信息页面
        model.addAttribute("mainPage",request.getContextPath()+"foreview/view.jsp");

//        标题栏显示的网页标题
        model.addAttribute("pageTitle",blog.getTitle());

        return  "mainTemp";
    }

//    lucene查询
    @RequestMapping("/query")
    public String query(String queryKey,Model model,HttpServletRequest request){
        SolrQuery query = new SolrQuery();
//        设置查询条件
        query.setQuery(queryKey);
//        设置分页(还没解决)
        query.setStart(0);
        query.setRows(PAGESIZE);
//        设置默认域
        query.set("df","blog_keywords");
//        设置高亮显示
        query.setHighlight(true);
//        设置高亮显示的域
        query.addHighlightField("blog_summary").addHighlightField("blog_title");
//        设置前缀和后缀
        query.setHighlightSimplePre("<em style='color:red'>");
        query.setHighlightSimplePost("</em>");
//        执行查询
        SolrDocumentList results = null;
        QueryResponse queryResponse = null;
        try {
            queryResponse = solrServer.query(query);
//            获得查询结果
            results = queryResponse.getResults();
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("resultTotal",results.getNumFound());
        List<Blog> blogs = new ArrayList<>();
//        遍历结果集
        for (SolrDocument doc : results){
            Blog blog = new Blog();
            blog.setId(Integer.parseInt((String) doc.get("id")));
//            获得高亮显示内容
            Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
//            根据key先获得数组对象
            List<String> summarys = highlighting.get(doc.get("id")).get("blog_summary");
            List<String> titles = highlighting.get(doc.get("id")).get("blog_title");
//            判断若没有高亮显示内容则显示原有内容，否则显示高亮内容
            String blog_summary;
            String blog_title;
            if(summarys==null){
                blog_summary = (String)doc.get("blog_content");
            }else {
                blog_summary = summarys.get(0);
            }
            if(titles==null){
                blog_title = (String)doc.get("blog_title");
            }else {
                blog_title = titles.get(0);
            }
            blog.setSummary(blog_summary);
            blog.setTitle(blog_title);
            Date release_date = (Date) doc.get("release_date");
            String date = new SimpleDateFormat().format(release_date);
            blog.setReleaseDateStr(date);
            blogs.add(blog);
        }
        model.addAttribute("blogList",blogs);
//        回显
        model.addAttribute("q", queryKey);
        model.addAttribute("mainPage",request.getContextPath()+"foreview/result.jsp");
        model.addAttribute("pageCode","");
        return  "mainTemp";
    }

}
