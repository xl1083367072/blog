package com.xl.mapper;

import com.xl.pojo.BlogType;
import com.xl.pojo.BlogTypeExample;
import java.util.List;

public interface BlogTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogType record);

    int insertSelective(BlogType record);

    List<BlogType> selectByExample(BlogTypeExample example);

    BlogType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogType record);

    int updateByPrimaryKey(BlogType record);

    List<BlogType> countList();
}