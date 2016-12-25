package com.xc.common;

import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/2/4
 * Time: 15:36
 * To change this template use File | Settings | File Templates
 */
@Service
public class CommonBean1 {
    private String name;

    public CommonBean1(){
        System.out.println("****************************");
        System.out.println("CommonBean1 构造方法");
        System.out.println("****************************");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
