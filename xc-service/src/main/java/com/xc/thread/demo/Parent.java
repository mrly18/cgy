package com.xc.thread.demo;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/25
 * Time: 11:02
 * To change this template use File | Settings | File Templates
 */
public class Parent {
    public int i=10;

    public synchronized void print(){
        System.out.println("parent 打印 i="+i);
        i--;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void serviceMethod(){
        try{
            System.out.println("父类下一步进入睡眠，线程名："+Thread.currentThread().getName()+" 时间："+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("父类睡眠结束，线程名："+Thread.currentThread().getName()+" 时间："+System.currentTimeMillis());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
