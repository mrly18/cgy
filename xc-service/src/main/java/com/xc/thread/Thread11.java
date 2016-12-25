package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/14
 * Time: 17:44
 * To change this template use File | Settings | File Templates
 */
public class Thread11 extends Thread {
//    @Override
//    public void run() {
//        try {
//            System.out.println("当前线程睡前："+Thread.currentThread().getName());
//            Thread.sleep(2000);
//            System.out.println("当前线程睡后：" + Thread.currentThread().getName());
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//    }

    @Override
    public void run() {
        try {
            System.out.println("当前线程睡前："+Thread.currentThread().getName());
            System.out.println("begin="+System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("当前线程睡后：" + Thread.currentThread().getName());
            System.out.println("  end="+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
