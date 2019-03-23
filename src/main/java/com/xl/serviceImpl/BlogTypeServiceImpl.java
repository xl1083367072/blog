package com.xl.serviceImpl;

import com.xl.mapper.BlogTypeMapper;
import com.xl.pojo.Blog;
import com.xl.pojo.BlogType;
import com.xl.service.BlogService;
import com.xl.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogTypeServiceImpl implements BlogTypeService {

    @Autowired
    private BlogTypeMapper blogTypeMapper;

    @Autowired
    private BlogService blogService;

    @Override
    public List<BlogType> countList() {
        return blogTypeMapper.countList();
    }


    /**
     * 根据博客id查询对应的博客类型信息
     * @param id
     * @return
     */
    @Override
    public BlogType findByBlogId(Integer id) {
        Blog blog = blogService.findById(id);
        return blogTypeMapper.selectByPrimaryKey(blog.getType_id());
    }

//    根据id查询博客类型

    @Override
    public BlogType findById(Integer id) {
        return blogTypeMapper.selectByPrimaryKey(id);
    }
}
