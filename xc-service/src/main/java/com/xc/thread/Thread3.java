package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/9
 * Time: 19:53
 * To change this template use File | Settings | File Templates
 */
public class Thread3 extends Thread {
    private int i;

    public Thread3(int i){
        super();
        this.i=i;
    }

    @Override
    public void run() {
        System.out.println("当前线程"+Thread.currentThread().getName()+this.i);
    }
}
