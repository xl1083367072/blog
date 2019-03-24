package com.xl.controller;

import com.xl.pojo.Blog;
import com.xl.service.BlogService;
import com.xl.utils.PageBean;
import com.xl.utils.PageUtil;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

//    声明成static好处是此控制器加载后，这个变量就会一直存在于内存
    private static  final int PAGESIZE = 10;

    @Autowired
    private BlogService blogService;

    /**
     * 根据所传参数查询并显示不同的内容页面
     * @param typeId 根据博客类型
     * @param releaseDate   根据博客日期
     * @param page  第几页
     * @param modelMap  封装数据
     * @param request
     * @return
     */
    @RequestMapping("/index")
    public String index(@RequestParam(value="page",required=false)String page, @RequestParam(value="typeId",required=false)String typeId,
                        @RequestParam(value="releaseDate",required=false)String releaseDate, HttpServletRequest request, ModelMap modelMap, HttpSession session) throws Exception{
        if(session.isNew()){
            ServletContext servletContext = request.getServletContext();
            Integer count = (Integer) servletContext.getAttribute("count");
            count++;
            servletContext.setAttribute("count",count);
            FileUtils.writeStringToFile(new File(servletContext.getRealPath("/")+"count.txt"),String.valueOf(count));
        }
        if(page==null||page.equals("")){
            page="1";
        }
        Integer pageNo=Integer.parseInt(page);

        PageBean pageBean=new PageBean();
        pageBean.setCurrPage(pageNo);
        pageBean.setPageSize(PAGESIZE);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("typeId", typeId);
        map.put("releaseDateStr", releaseDate);
        List<Blog> blogList = blogService.list(map);

        for(Blog blog:blogList){
            //用于将存放博客内容里面的图片抽出并生成缩略图-用于前端页面展示
            List<String> imagesList=blog.getImagesList();

            String blogInfo=blog.getContent();
            Document doc= Jsoup.parse(blogInfo);

            //查找扩展名是jpg的图片：根据页面需要拿n张图片,这里拿了3张
            Elements jpgs=doc.select("img[src$=.jpg]");
            Elements gifs = doc.select("img[src$=.gif]");
            suffix(imagesList, jpgs);
            suffix(imagesList, gifs);
            blog.setImagesList(imagesList);
        }
        modelMap.addAttribute("blogList", blogList);

        //查询参数
        StringBuffer param=new StringBuffer();
        if(typeId!=null&&!typeId.equals("")){
            param.append("typeId="+typeId+"&");
        }
        if(releaseDate!=null&&!releaseDate.equals("")){
            param.append("releaseDateStr="+releaseDate+"&");
        }

        Long totalRecord=blogService.getTotal(map);
        String genPagination= PageUtil.genPagination(request.getContextPath()+"/index.action",totalRecord,pageNo,PAGESIZE,param.toString());

        modelMap.addAttribute("pageCode",genPagination);
        modelMap.addAttribute("mainPage", "foreview/list.jsp");
        modelMap.addAttribute("pageTitle","个人博客系统");

        /**
         * 将页面常用信息放入session域中
         */
//        博主信息
//        Blogger blogger = bloggerService.findByUserName("admin");
//        session.setAttribute("blogger",blogger);
//
////      博客类型
//        List<BlogType> blogTypes = blogTypeService.countList();
//        session.setAttribute("blogTypeCountList",blogTypes);
//
////        友情链接
//        List<Link> links = linkService.list(null);
//        session.setAttribute("linkList",links);
//
////        按日期分类
//        List<Blog> blogs = blogService.countList();
//        session.setAttribute("blogCountList",blogs);

        return "mainTemp";
    }

    private void suffix(List<String> imagesList, Elements img) {
        if (img!=null && img.size()>0) {
            for(int i=0;i<img.size();i++){
                Element jpg=img.get(i);
                imagesList.add(jpg.toString());
                if(i==1){
                    break;
                }
            }
        }
    }


}
