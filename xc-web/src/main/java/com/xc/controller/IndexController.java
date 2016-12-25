package com.xc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/2/6
 * Time: 10:37
 * To change this template use File | Settings | File Templates
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String testController1(Model model){
        return "index";
    }

    @RequestMapping("/hello")
    public String testController2(Model model){
        model.addAttribute("testVm1","你好，世界！");
        return "hello";
    }

    @RequestMapping("/welcome")
    public String testController3(Model model){
        return "hello";
    }
}
