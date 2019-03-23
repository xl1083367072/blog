package com.xl.listener;

import com.xl.pojo.Blog;
import com.xl.pojo.BlogType;
import com.xl.pojo.Blogger;
import com.xl.pojo.Link;
import com.xl.service.BlogService;
import com.xl.service.BlogTypeService;
import com.xl.service.BloggerService;
import com.xl.service.LinkService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.util.List;

/**
 * 自定义监听器，项目启动时会自动执行初始化方法
 * 将页面一些常用资源放入servletContext域
 */
@Component
public class MyListener implements ServletContextListener, ApplicationContextAware {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent){

        System.out.println("=============================================");

        ServletContext servletContext = servletContextEvent.getServletContext();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        BloggerService bloggerService = context.getBean(BloggerService.class);
        //        博主信息
        Blogger blogger = bloggerService.findByUserName("root");
        servletContext.setAttribute("blogger",blogger);

        BlogTypeService blogTypeService = context.getBean(BlogTypeService.class);
        //      博客类型
        List<BlogType> blogTypes = blogTypeService.countList();
        servletContext.setAttribute("blogTypeCountList",blogTypes);

        LinkService linkService = context.getBean(LinkService.class);
        //        友情链接
        List<Link> links = linkService.list(null);
        servletContext.setAttribute("linkList",links);

        BlogService blogService = context.getBean(BlogService.class);
        //        按日期分类
        List<Blog> blogs = blogService.countList();
        servletContext.setAttribute("blogCountList",blogs);
        File file = new File(servletContext.getRealPath("/")+"count.txt");
        try {
            List<String> list = FileUtils.readLines(file, "utf-8");
            Integer count = Integer.parseInt(list.get(0));
            System.out.println("============================="+count);
            servletContext.setAttribute("count",count);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
