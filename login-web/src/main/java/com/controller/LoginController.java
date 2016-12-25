package com.controller;

import com.login.LoginCommand;
import com.login.User;
import com.login.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by lenovo on 2016/4/18.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/index.html")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value="/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand){
        boolean isValidUser=userService.hasMatchUser(loginCommand.getUserName(),loginCommand.getPassword());
        if(!isValidUser){
            //第一个参数：视图的逻辑名；第二个参数：数据模型名称；第三个参数：数据模型对象
            //数据模型对象将以数据模型名称为key放置到request的属性中
            return new ModelAndView("login","error","用户名或密码错误");
        }else{
            User user=userService.findUserByUserName(loginCommand.getUserName());
            user.setLastIp(request.getRemoteAddr());
            System.out.println("用户IP："+user.getLastIp());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user",user);
            return new ModelAndView("main");
        }
    }
}
