package com.xl.service;

import com.xl.pojo.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findCommentByBlogId(Integer id);

    void addComment(Comment comment);

//    查询state为0即没有通过审核的评论
    List<Comment> findCommentByState(Integer state);

//    更新评论
    void updateState(Comment comment);

//    根据id删除评论
    void removeCommentById(Integer id);

//    查询所有评论
    List<Comment> commentList();

}
