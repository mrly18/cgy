package com.testextends;

/**
 * Created by IntelliJ IDEA
 * User: lenovo
 * Date: 2016/4/28
 * Time: 22:50
 * To change this template use File | Settings | File Templates
 */
public class Child extends Parent {

    public Child(){}

    public Child(int a){
        super("");
        System.out.println("子类有参构造方法第一行，接下来是调用父类有参构造方法");
    }

    public void say(double a){
        System.out.println("子类的say（double b）方法");
    }

    /*public void say(int a){
        System.out.println("子类的say（int b）方法");
    }*/

    /*public int fly(String type){
        System.out.println("子类的飞");
        return 0;
    }*/

    public static void main(String[] args) {
        Child child=new Child();
//        Parent parent=new Parent();
        Parent parent=child;
        System.out.println(child.getClass()==parent.getClass());
    }

    public static void test1(){
        Child[] children=new Child[5];
        Parent[] parents=children;
        parents[0]=new Parent();
        children[0].say(1.2);
    }

    public static void test2(){
        Child child=new Child();
        child.say(12);
    }


}
