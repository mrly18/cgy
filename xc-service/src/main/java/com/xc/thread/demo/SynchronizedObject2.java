package com.xc.thread.demo;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/21
 * Time: 18:24
 * To change this template use File | Settings | File Templates
 */
public class SynchronizedObject2 {
    public synchronized void printString(){
        System.out.println("begin");
        if("a".equals(Thread.currentThread().getName())){
            System.out.println("a线程永远suspend了");
            Thread.currentThread().suspend();
        }
    }

    public synchronized void printString(String name){
        synchronized(name){
            System.out.println(name);
        }
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
