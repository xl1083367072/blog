package com.xl.service;

import com.xl.pojo.BlogType;

import java.util.List;

public interface BlogTypeService {

    List<BlogType> countList();

    BlogType findByBlogId(Integer id);

}
