package com.xl.service;

import com.xl.pojo.Link;

import java.util.List;
import java.util.Map;

public interface LinkService {

    List<Link> list(Map<String,Object> map);

    void addLink(Link link);

    void modifyLink(Link link);

    void removeLink(Integer id);

}
