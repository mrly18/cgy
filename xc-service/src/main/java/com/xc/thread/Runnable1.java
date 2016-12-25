package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/9
 * Time: 20:03
 * To change this template use File | Settings | File Templates
 */
public class Runnable1 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
