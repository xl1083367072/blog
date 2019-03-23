package com.xl.controller.backController;

import com.alibaba.fastjson.JSONObject;
import com.xl.pojo.Link;
import com.xl.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class LinkAdminController {

    @Autowired
    private LinkService linkService;

    @ResponseBody
    @RequestMapping("/linkList")
    public List<Link> linkList(){

        List<Link> links = linkService.list(null);

        return links;
    }


    @ResponseBody
    @RequestMapping("/addLink")
    public String addLink(Link link,HttpServletRequest request){

        JSONObject jsonObject = new JSONObject();

        if(link!=null){
            linkService.addLink(link);
            jsonObject.put("success",true);
        }

        //        更新域中链接信息
        List<Link> links = linkList();
        request.getServletContext().setAttribute("linkList",links);

        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/modifyLink")
    public String modifyLink(Link link,HttpServletRequest request){

        JSONObject jsonObject = new JSONObject();

        if(link!=null){
            linkService.modifyLink(link);
            jsonObject.put("success",true);
        }

        //        更新域中链接信息
        List<Link> links = linkList();
        request.getServletContext().setAttribute("linkList",links);

        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/removeLink")
    public String removeLink(String ids, HttpServletRequest request){

        JSONObject jsonObject = new JSONObject();

        if(ids!=null&&ids.length()>0){
            String[] split = ids.split(",");
            for (String id:split) {
                linkService.removeLink(Integer.parseInt(id));
            }
            jsonObject.put("success",true);
        }

//        更新域中链接信息
        List<Link> links = linkList();
        request.getServletContext().setAttribute("linkList",links);


        return jsonObject.toJSONString();
    }


}
