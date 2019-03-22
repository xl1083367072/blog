package com.xl.serviceImpl;

import com.xl.mapper.BlogMapper;
import com.xl.pojo.Blog;
import com.xl.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<Blog> list(Map<String, Object> map) {
        return blogMapper.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return blogMapper.getTotal(map);
    }

    @Override
    public List<Blog> countList() {
        return blogMapper.countList();
    }

    @Override
    public Blog findById(Integer id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public Blog lastBlog(Integer id) {
        return blogMapper.lastBlog(id);
    }

    @Override
    public Blog nextBlog(Integer id) {
        return blogMapper.nextBlog(id);
    }

    @Override
    public void update(Blog blog) {
        blogMapper.updateByPrimaryKeySelective(blog);
    }

    @Override
    public int save(Blog blog) {
        return blogMapper.insertSelective(blog);
    }
}
