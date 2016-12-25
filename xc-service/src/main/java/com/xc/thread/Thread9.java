package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/14
 * Time: 17:21
 * To change this template use File | Settings | File Templates
 */
public class Thread9 extends Thread {
    @Override
    public void run() {
        System.out.println("当前线程活动状态："+this.isAlive());
    }
}
