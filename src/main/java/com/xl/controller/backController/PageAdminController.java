package com.xl.controller.backController;

import com.alibaba.fastjson.JSONObject;
import com.xl.pojo.Blog;
import com.xl.pojo.BlogType;
import com.xl.pojo.Blogger;
import com.xl.pojo.Link;
import com.xl.service.BlogService;
import com.xl.service.BlogTypeService;
import com.xl.service.BloggerService;
import com.xl.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class PageAdminController {

    @Autowired
    private BlogTypeService blogTypeService;

    @Autowired
    private BloggerService bloggerService;

    @Autowired
    private LinkService linkService;

    @Autowired
    private BlogService blogService;

    @RequestMapping("/writeBlog")
    public String writeBlog(Model model){
        List<BlogType> blogTypeList = blogTypeService.countList();
        model.addAttribute("blogTypeCountList",blogTypeList);
        return "admin/writeBlog";
    }

    @ResponseBody
    @RequestMapping("/refresh")
    public String refresh(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        ServletContext servletContext = request.getServletContext();
        //        按日期分类
        List<Blog> blogs = blogService.countList();
        servletContext.setAttribute("blogCountList",blogs);
        //        友情链接
        List<Link> links = linkService.list(null);
        servletContext.setAttribute("linkList",links);
        //      博客类型
        List<BlogType> blogTypes = blogTypeService.countList();
        servletContext.setAttribute("blogTypeCountList",blogTypes);
        //        博主信息
        Blogger blogger = bloggerService.findByUserName("root");
        servletContext.setAttribute("blogger",blogger);
        jsonObject.put("success",true);
        return jsonObject.toJSONString();
    }

}
