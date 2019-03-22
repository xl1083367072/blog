package com.xl.service;

import com.xl.pojo.Blogger;
import org.apache.ibatis.annotations.Param;

public interface BloggerService {

    Blogger findByUserName(@Param("username") String username);

}
