package com.xc.thread.demo;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/24
 * Time: 17:37
 * To change this template use File | Settings | File Templates
 */
public class SynchronizedAgainIn {
    public synchronized void service1(){
        System.out.println(Thread.currentThread().getName()+"\tservice1");
        service2();
    }

    public synchronized void service2(){
        System.out.println(Thread.currentThread().getName()+"\tservice2");
        service3();
    }

    public synchronized void service3(){
        System.out.println(Thread.currentThread().getName()+"\tservice3");
    }
}
