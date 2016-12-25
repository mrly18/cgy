package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/14
 * Time: 17:31
 * To change this template use File | Settings | File Templates
 */
public class Thread10 extends Thread {
    public Thread10(){
        System.out.println("构造方法调用者："+Thread.currentThread().getName());
        System.out.println("构造方法调用者状态："+Thread.currentThread().isAlive());
        System.out.println("构造方法中调用this.getName()：" + this.getName());
        System.out.println("构造方法中调用this.isAlive()：" + this.isAlive());
    }

    @Override
    public void run() {
        System.out.println("run()方法调用者："+Thread.currentThread().getName());
        System.out.println("run()方法调用者状态："+Thread.currentThread().isAlive());
        System.out.println("run()中调用this.getName()：" + this.getName());
        System.out.println("run()中调用this.isAlive()：" + this.isAlive());
    }
}
