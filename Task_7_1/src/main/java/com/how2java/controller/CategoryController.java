package com.how2java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 告诉spring mvc这是一个控制器类
@Controller
public class CategoryController {

    @RequestMapping(value = "/profession", method = RequestMethod.GET)
    public String goM() {
        return "profession";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/quit",method = RequestMethod.GET)
    public String quit(){
        return "none";
    }
}
