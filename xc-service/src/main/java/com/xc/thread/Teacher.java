package com.xc.thread;

/**
 * 父类必须有无参构造函数（1.默认2.若有有参构造函数，则显示创建无参构造函数）
 */
public class Teacher {
    public Teacher(){
//        this("");
        System.out.println("我是Teacher-无参构造");
    }

    public Teacher(String name){
//        this();
        System.out.println("我是Teacher-有参构造");
    }

    public void say(){
        System.out.println("我是老师");
    }
}
