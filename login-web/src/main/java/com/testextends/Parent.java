package com.testextends;

/**
 * Created by IntelliJ IDEA
 * User: lenovo
 * Date: 2016/4/28
 * Time: 22:50
 * To change this template use File | Settings | File Templates
 */
public class Parent {
    public Parent(){
        System.out.println("父类无参构造方法");
    }

    public Parent(String a){
        System.out.println("父类有参构造方法");
    }

    public void say(int a){
        System.out.println("父类say（int a）方法");
    }

    public void fly(String type){
        System.out.println("父类的飞");
    }
}
