package com.xl.controller.backController;

import com.alibaba.fastjson.JSONObject;
import com.xl.pojo.Blog;
import com.xl.pojo.Comment;
import com.xl.service.BlogService;
import com.xl.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CommentAdminController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @ResponseBody
    @RequestMapping("/commentList")
    public List<Comment> commentList(Integer state){

        List<Comment> commentList = commentService.findCommentByState(state);
        for (Comment comment : commentList){
            Blog blog = blogService.findById(comment.getBlog_id());
            comment.setBlog(blog);
        }

        return commentList;
    }

    @ResponseBody
    @RequestMapping("/reviewComment")
    public String reviewComment(String ids,String state){
        JSONObject jsonObject = new JSONObject();
        if(ids!=null&&ids.length()>0){
//            将id字符串拆分
            String[] split = ids.split(",");
            for (String id : split){
//                状态为1代表通过
                if(state.equals("1")){
                    Comment comment = new Comment();
                    comment.setState(1);
                    comment.setId(Integer.parseInt(id));
                    commentService.updateState(comment);
                }else{
//                    否则就删除这个评论
                    commentService.removeCommentById(Integer.parseInt(id));
                }
            }
            jsonObject.put("success",true);
        }
        return jsonObject.toJSONString();
    }

}
