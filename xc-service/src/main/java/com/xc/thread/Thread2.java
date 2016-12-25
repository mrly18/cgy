package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/9
 * Time: 18:25
 * To change this template use File | Settings | File Templates
 */
public class Thread2 extends Thread {

    @Override
    public void run() {
        try {
            for (int i=0;i<10;i++){
                //Math.random()是令系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值
                int time=(int)(Math.random()*1000);
                Thread.sleep(time);
                System.out.println("当前线程："+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
