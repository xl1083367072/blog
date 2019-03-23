package com.xl.controller.backController;

import com.alibaba.fastjson.JSONObject;
import com.xl.pojo.BlogType;
import com.xl.service.BlogService;
import com.xl.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogTypeAdminController {

    @Autowired
    private BlogTypeService blogTypeService;

    @Autowired
    private BlogService blogService;

    @ResponseBody
    @RequestMapping("/blogTypeList")
    public List<BlogType> blogTypeList(){
        List<BlogType> blogTypes = blogTypeService.countList();
        return blogTypes;
    }

    @ResponseBody
    @RequestMapping("/addBlogType")
    public String addBlogType(BlogType blogType){
        JSONObject jsonObject = new JSONObject();
        if(blogType!=null){
            blogTypeService.add(blogType);
            jsonObject.put("success",true);
        }

        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/modifyBlogType")
    public String modifyBlogType(BlogType blogType){
        JSONObject jsonObject = new JSONObject();
        if(blogType!=null){
            blogTypeService.modify(blogType);
            jsonObject.put("success",true);
        }
        return jsonObject.toJSONString();
    }

    /**
     * 删除博客类型，连同该类型下的所有博客都删除掉，相关索引删除掉
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/removeBlogType")
    public  String removeBlogType(String ids){
        JSONObject jsonObject = new JSONObject();

        if(ids!=null&&ids.length()>0){
            String[] split = ids.split(",");
            for (String id:split) {
//                删除博客
                blogService.removeByTypeId(Integer.parseInt(id));
                blogTypeService.remove(Integer.parseInt(id));
            }
            jsonObject.put("success",true);
        }

        return jsonObject.toJSONString();
    }

}
