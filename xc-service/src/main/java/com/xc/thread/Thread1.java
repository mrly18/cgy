package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/9
 * Time: 18:04
 * To change this template use File | Settings | File Templates
 */
public class Thread1 extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("Thread1-run");
    }
}
