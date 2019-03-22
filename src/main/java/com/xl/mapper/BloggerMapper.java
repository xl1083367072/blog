package com.xl.mapper;

import com.xl.pojo.Blogger;
import com.xl.pojo.BloggerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BloggerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Blogger record);

    int insertSelective(Blogger record);

    List<Blogger> selectByExampleWithBLOBs(BloggerExample example);

    List<Blogger> selectByExample(BloggerExample example);

    Blogger selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Blogger record);

    int updateByPrimaryKeyWithBLOBs(Blogger record);

    int updateByPrimaryKey(Blogger record);

    Blogger findByUserName(@Param("username") String username);

}