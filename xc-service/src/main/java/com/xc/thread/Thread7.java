package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/14
 * Time: 17:02
 * To change this template use File | Settings | File Templates
 */
public class Thread7 extends Thread {

    public Thread7(){
        System.out.println("调用构造方法的线程是："+Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("调用run方法的线程是："+Thread.currentThread().getName());
    }
}
