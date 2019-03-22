package com.xl.mapper;

import com.xl.pojo.Blog;
import com.xl.pojo.BlogExample;
import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Blog record);

    int insertSelective(Blog record);

    List<Blog> selectByExampleWithBLOBs(BlogExample example);

    List<Blog> selectByExample(BlogExample example);

    Blog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);

    List<Blog> list(Map<String,Object> map);

    Long getTotal(Map<String,Object> map);

    List<Blog> countList();

    Blog lastBlog(Integer id);

    Blog nextBlog(Integer id);

}