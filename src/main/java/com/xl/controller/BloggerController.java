package com.xl.controller;

import com.xl.pojo.Blogger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Component
@RequestMapping("/blogger")
public class BloggerController {

    @RequestMapping("/aboutMe")
    public String aboutMe(Model model){
        model.addAttribute("mainPage","/foreview/info.jsp");
        return "mainTemp";
    }

    @RequestMapping("/login")
    public String login(Blogger currentUser, HttpSession session,Model model){
//        代表一个登录的主体
        Subject subject = SecurityUtils.getSubject();
//        将登录的用户名和密码封装进令牌对象中
        UsernamePasswordToken token = new UsernamePasswordToken(currentUser.getUser_name(),currentUser.getPassword());
        model.addAttribute("currentUser",currentUser);
        try {
//            登录验证
            subject.login(token);
//            验证通过，将此主体放入session中
            session.setAttribute("subject",subject);
//            跳转页面
            return "admin/main";
        }catch (AuthenticationException e){
//            抛出异常，证明验证失败，返回错误信息
            model.addAttribute("errorInfo","用户名或密码错误");
            return "login";
        }
    }

}
