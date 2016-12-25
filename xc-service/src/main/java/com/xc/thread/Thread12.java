package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/14
 * Time: 18:18
 * To change this template use File | Settings | File Templates
 */
public class Thread12 extends Thread {
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("i="+(i+1));
        }
    }
}
