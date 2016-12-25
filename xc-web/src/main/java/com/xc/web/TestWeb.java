package com.xc.web;

import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/2/3
 * Time: 10:09
 * To change this template use File | Settings | File Templates
 */
@Service
public class TestWeb {

    private String name;

    private int age;

    public TestWeb(){
        System.out.println("#######################");
        System.out.println("TestWeb的gon构造方法");
        System.out.println("#######################");
    }

    public static void main(String[] args) {
        System.out.println("hello web");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
