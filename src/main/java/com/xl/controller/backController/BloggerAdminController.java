package com.xl.controller.backController;

import com.alibaba.fastjson.JSONObject;
import com.xl.pojo.Blogger;
import com.xl.service.BloggerService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class BloggerAdminController {

    @Autowired
    private BloggerService bloggerService;

    @ResponseBody
    @RequestMapping("/findBlogger")
    public Blogger findBlogger(Integer id){

        Blogger blogger = bloggerService.findById(id);

        return blogger;
    }

    @RequestMapping("/modifyInfo")
    public void modifyInfo(Blogger blogger, MultipartFile imageFile, HttpServletRequest request){
//      上传文件原名称
        String originalFilename = imageFile.getOriginalFilename();
//      获取项目存放真实路径
        ServletContext servletContext = request.getServletContext();
        String path = servletContext.getRealPath("/static/userImages");
//      获取上传文件后缀名
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
//      避免文件名重复，使用随机生成的文件名
        String rname = UUID.randomUUID().toString();
//      最终存放的文件名称
        String filename = rname + suffix;
//      存放路径加上文件名组成存放位置
        File filepath = new File( path+File.separator+filename);
        try {
//           上传文件
            imageFile.transferTo(filepath);
        }catch (Exception e){
            e.printStackTrace();
        }
        blogger.setImage_name(filename);
        bloggerService.modify(blogger);

//        重置域中博主信息
        servletContext.setAttribute("blogger",blogger);

    }

    @ResponseBody
    @RequestMapping("/modifyPassword")
    public String modifyPassword(@RequestParam("id") Integer id, String newPassword){

        JSONObject jsonObject = new JSONObject();

        if(id!=null){
//            生成盐
            String salt = new SecureRandomNumberGenerator().nextBytes().toString();
//            将密码用md5算法加密
            String password = new SimpleHash("md5", newPassword, salt, 2).toString();
            Blogger blogger = new Blogger();
            blogger.setId(id);
            blogger.setPassword(password);
            blogger.setSalt(salt);
            bloggerService.modify(blogger);
            jsonObject.put("success",true);
        }

        return jsonObject.toJSONString();
    }

}
