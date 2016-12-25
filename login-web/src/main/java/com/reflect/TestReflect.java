package com.reflect;

import com.reflect.domain.People;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by lenovo on 2016/4/22.
 */
public class TestReflect {
    public static People initByDefaultConst() throws Throwable{
        //①通过类加载器获取People类对象
        ClassLoader loader=Thread.currentThread().getContextClassLoader();
        Class clazz=loader.loadClass("com.reflect.domain.People");

        //②获取类的默认构造器对象并通过它实例化People
        //getDeclaredConstructor()可以获取全部访问级别的构造方法
        //getConstructor()只可以访问public的构造方法
        Constructor constructor=clazz.getDeclaredConstructor((Class[]) null);//无参数构造器，也可以这样getDeclaredConstructor()
//        Constructor constructor2=clazz.getDeclaredConstructor(String.class,int.class,String.class);//有参数构造器
        People people= (People) constructor.newInstance();

        //通过反射方法设置属性
        Method setName=clazz.getMethod("setName", String.class);
        setName.invoke(people,"Jack");
        Method setAge=clazz.getMethod("setAge", int.class);
        setAge.invoke(people,20);
        Method setGender=clazz.getMethod("setGender", String.class);
        setGender.invoke(people,"男");
        //类.class和对象.getClass()以及对象.getClass()都是返回类的Class对象
        System.out.println(people.getClass());
        System.out.println(Class.forName("com.reflect.domain.People"));
        System.out.println(People.class);
        return people;
    }

    public static void main(String[] args) {
        try {
            People people=initByDefaultConst();
//            people.say();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
