package com.xl.serviceImpl;

import com.xl.mapper.BloggerMapper;
import com.xl.pojo.Blogger;
import com.xl.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BloggerServiceImpl implements BloggerService {

    @Autowired
    private BloggerMapper bloggerMapper;

    @Override
    public Blogger findByUserName(String username) {
        return bloggerMapper.findByUserName(username);
    }

    @Override
    public Blogger findById(Integer id) {
        return bloggerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void modify(Blogger blogger) {
        bloggerMapper.updateByPrimaryKeySelective(blogger);
    }
}
