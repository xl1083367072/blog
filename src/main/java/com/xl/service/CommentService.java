package com.xl.service;

import com.xl.pojo.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findCommentByBlogId(Integer id);

    void addComment(Comment comment);

}
