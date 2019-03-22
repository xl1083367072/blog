package com.xl.serviceImpl;

import com.xl.mapper.CommentMapper;
import com.xl.pojo.Comment;
import com.xl.pojo.CommentExample;
import com.xl.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> findCommentByBlogId(Integer id) {
        CommentExample example = new CommentExample();
        example.createCriteria().andBlog_idEqualTo(id).andStateEqualTo(1);
//        state为1的表示审核通过
        List<Comment> comments = commentMapper.selectByExample(example);
        return comments;
    }

    @Override
    public void addComment(Comment comment) {
        comment.setComment_date(new Date());
        commentMapper.insertSelective(comment);
    }
}
