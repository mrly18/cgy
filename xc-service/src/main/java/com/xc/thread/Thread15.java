package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/15
 * Time: 11:27
 * To change this template use File | Settings | File Templates
 */
public class Thread15 extends Thread {
    @Override
    public void run() {
        try{
            for(int i=0;i<100000;i++){
                System.out.println("i="+(i+1));
            }
            System.out.println(Thread.currentThread().getName()+"线程启动");
            Thread.sleep(2000);
            System.out.println("线程结束");
        }catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName()+"先在主线程中打断它，再调用sleep时抛出异常");
            e.printStackTrace();
        }
    }
}
