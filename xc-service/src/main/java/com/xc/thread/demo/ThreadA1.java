package com.xc.thread.demo;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/24
 * Time: 15:40
 * To change this template use File | Settings | File Templates
 */
public class ThreadA1 extends Thread {
    private SynchronizedIsObject synchronizedIsObject;

    public ThreadA1(SynchronizedIsObject synchronizedIsObject){
        this.synchronizedIsObject=synchronizedIsObject;
    }

    @Override
    public void run() {
        synchronizedIsObject.methodA();
    }
}
