package com.xl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

//  重定向到主界面
    @RequestMapping("/")
    public String index(){
        return  "redirect:/index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
