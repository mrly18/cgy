package com.xc.thread.demo;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/31
 * Time: 16:20
 * To change this template use File | Settings | File Templates
 */
public class ChangeSyn {
    private String lock="123";

    public void testMethod(){
        synchronized(lock){
            System.out.println(Thread.currentThread().getName()+"\t进来了");
            lock="456";
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"\t结束了");
        }
    }
}
