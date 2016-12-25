package com.reflect.domain;

/**
 * Created by lenovo on 2016/4/22.
 */
public class People {
    private String name;
    private int age;
    private String gender;

    public People(){
        System.out.println("调用了无参构造方法");
    }

    public People(String name,int age,String gender){
        System.out.println("调用了有参构造方法");
        this.name=name;
        this.age=age;
        this.gender=gender;
    }

    public void say(){
        System.out.println("★★★★★★★★★★");
        System.out.println("我是："+name+"，年龄："+age+"，性别："+gender);
        System.out.println("★★★★★★★★★★");
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
