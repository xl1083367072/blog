package com.xl.mapper;

import com.xl.pojo.Link;
import com.xl.pojo.LinkExample;
import java.util.List;
import java.util.Map;

public interface LinkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Link record);

    int insertSelective(Link record);

    List<Link> selectByExample(LinkExample example);

    Link selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Link record);

    int updateByPrimaryKey(Link record);

    List<Link> list(Map<String,Object> map);
}