package com.xl.serviceImpl;

import com.xl.mapper.BloggerMapper;
import com.xl.pojo.Blogger;
import com.xl.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloggerServiceImpl implements BloggerService {

    @Autowired
    private BloggerMapper bloggerMapper;

    @Override
    public Blogger findByUserName(String username) {
        return bloggerMapper.findByUserName(username);
    }
}
