package com.reflect.classloader;

/**
 * Created by lenovo on 2016/4/25.
 */
public class TestClassLoader {
    public static void main(String[] args) {
        ClassLoader loader=Thread.currentThread().getContextClassLoader();
        System.out.println("当前的ClassLoader："+loader);//AppClassLoader
        System.out.println("父类的ClassLoader："+loader.getParent());//ExtClassLoader
        //null，根加载器是用c++写的，访问不到
        System.out.println("顶级的ClassLoader："+loader.getParent().getParent());
    }
}
