package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/14
 * Time: 17:07
 * To change this template use File | Settings | File Templates
 */
public class Thread8 extends Thread {
    public Thread8(){
        System.out.println("构造方法调用者："+Thread.currentThread().getName());
        System.out.println("构造方法中调用this.getName()：" + this.getName());
    }

    @Override
    public void run() {
        System.out.println("run()方法调用者："+Thread.currentThread().getName());
        System.out.println("run()中调用this.getName()：" + this.getName());
    }
}
