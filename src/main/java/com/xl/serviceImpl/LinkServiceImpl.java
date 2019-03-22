package com.xl.serviceImpl;

import com.xl.mapper.LinkMapper;
import com.xl.pojo.Link;
import com.xl.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkMapper linkMapper;

    @Override
    public List<Link> list(Map<String, Object> map) {
        return linkMapper.list(map);
    }
}
