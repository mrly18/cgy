package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/9
 * Time: 18:04
 * To change this template use File | Settings | File Templates
 */
public class Thread0 extends Thread {

    public Thread0(Runnable runnable){
        super();
//        runnable.run();
        System.out.println("Thread0");
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Thread0-run");
    }
}
