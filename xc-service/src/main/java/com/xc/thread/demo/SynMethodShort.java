package com.xc.thread.demo;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/29
 * Time: 17:14
 * To change this template use File | Settings | File Templates
 */
public class SynMethodShort {
    private String getData1;
    private String getData2;

//    public synchronized void doLongTimeTask(){
    public void doLongTimeTask(){
        System.out.println(Thread.currentThread().getName()+"开始");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String data1="长时间处理任务后从远程返回的值1，线程名："+Thread.currentThread().getName();
        String data2="长时间处理任务后从远程返回的值2，线程名："+Thread.currentThread().getName();
        synchronized(this){
            getData1=data1;
            getData2=data2;
        }
        System.out.println(getData1);
        System.out.println(getData2);
        System.out.println(Thread.currentThread().getName()+"结束");
    }

}
