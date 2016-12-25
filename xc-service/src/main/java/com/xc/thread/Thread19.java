package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/15
 * Time: 14:22
 * To change this template use File | Settings | File Templates
 */
public class Thread19 extends Thread {
    @Override
    public void run() {
        while(true){
            if(this.isInterrupted()){
                System.out.println("停止了");
                return;
            }
            System.out.println("time="+System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        System.out.println("我是不会用hello world的");
    }
}
