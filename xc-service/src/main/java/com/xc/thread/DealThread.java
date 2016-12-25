package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/31
 * Time: 9:25
 * To change this template use File | Settings | File Templates
 */
public class DealThread implements Runnable {
    public String username;
    public Object lock1=new Object();
    public Object lock2=new Object();

    public void setFlag(String username){
        this.username=username;
    }

    @Override
    public void run() {
        if("a".equals(this.username)){
            synchronized(lock1){
                try{
                    System.out.println("用户名："+this.username+"\t线程ID："+Thread.currentThread().getId());
                    Thread.sleep(3000);
                }catch(Exception e){
                    e.printStackTrace();
                }
                synchronized(lock2){
                    System.out.println("按lock1->lock2代码顺序执行");
                }
            }
        }
        if("b".equals(this.username)){
            synchronized(lock2){
                try{
                    System.out.println("用户名："+this.username+"\t线程ID："+Thread.currentThread().getId());
                    Thread.sleep(3000);
                }catch(Exception e){
                    e.printStackTrace();
                }
                synchronized(lock1){
                    System.out.println("按lock2->lock1代码顺序执行");
                }
            }
        }
    }
}
