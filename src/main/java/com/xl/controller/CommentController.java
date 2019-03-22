package com.xl.controller;

import com.alibaba.fastjson.JSONObject;
import com.xl.pojo.Comment;
import com.xl.service.BlogService;
import com.xl.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/saveComment")
    @ResponseBody
    public String saveComment(Comment comment, @RequestParam("imageCode") String imageCode, HttpSession session, HttpServletRequest request){

        String rand = (String)session.getAttribute("sRand");

        JSONObject jsonObject = new JSONObject();

//        若提交的验证码错误，则返回错误信息
        if(!imageCode.equals(rand)){
            jsonObject.put("success",false);
            jsonObject.put("errorInfo","验证码错误");
        }else {
//             获取回复人ip地址作为名称
            String remoteAddr = request.getRemoteAddr();
            comment.setUser_ip(remoteAddr);
            commentService.addComment(comment);
//            对应博客的回复数加1,审核通过才能加1
//            Blog blog = blogService.findById(comment.getBlog_id());
//            blog.setReply_hit(blog.getReply_hit()+1);
//            blogService.update(blog);
            jsonObject.put("success",true);
        }

        return  jsonObject.toJSONString();
    }


}
