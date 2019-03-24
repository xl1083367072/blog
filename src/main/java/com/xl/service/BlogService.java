package com.xl.service;

import com.xl.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogService {

    List<Blog> list(Map<String,Object> map);

    Long getTotal(Map<String,Object> map);

    List<Blog> countList();

    Blog findById(Integer id);

    Blog lastBlog(Integer id);

    Blog nextBlog(Integer id);

    void update(Blog blog);

    int save(Blog blog);

    List<Blog> findAll();

    void removeBlogById(Integer id);

    void removeByTypeId(Integer typeId);

    void modify(Blog blog);
}
