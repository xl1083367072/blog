package com.xl.controller.backController;

import com.xl.pojo.BlogType;
import com.xl.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class PageAdminController {

    @Autowired
    private BlogTypeService blogTypeService;

    @RequestMapping("/writeBlog")
    public String writeBlog(Model model){
        List<BlogType> blogTypeList = blogTypeService.countList();
        model.addAttribute("blogTypeCountList",blogTypeList);
        return "admin/writeBlog";
    }

}
