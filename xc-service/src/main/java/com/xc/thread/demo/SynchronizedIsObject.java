package com.xc.thread.demo;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/24
 * Time: 15:36
 * To change this template use File | Settings | File Templates
 */
public class SynchronizedIsObject {
    public synchronized void methodA(){
        try{
            System.out.println("begin methodA 线程名："+Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end methodA 线程名："+Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized void methodB(){
        try{
            System.out.println("begin methodB 线程名："+Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end methodB 线程名："+Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
