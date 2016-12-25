package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/15
 * Time: 10:40
 * To change this template use File | Settings | File Templates
 */
public class Thread14 extends Thread {
    @Override
    public void run() {
        try{
            System.out.println(Thread.currentThread().getName() + "线程启动");
            Thread.sleep(2000);
            System.out.println("线程停止");
        }catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName()+"沉睡中被停止，进入catch。线程状态："+this.isInterrupted());
            e.printStackTrace();
        }
    }
}
