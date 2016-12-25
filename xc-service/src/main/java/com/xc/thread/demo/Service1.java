package com.xc.thread.demo;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/29
 * Time: 14:31
 * To change this template use File | Settings | File Templates
 */
public class Service1 {
    public synchronized void testMethod(){
        if("a".equals(Thread.currentThread().getName())){
            System.out.println(Thread.currentThread().getName()+"开始时间"+System.currentTimeMillis());
            int i=1;
            while(i==1){
                if((""+Math.random()).substring(0,8).equals("0.123456")){
                    System.out.println("线程名："+Thread.currentThread().getName()+" 异常运行时间："+System.currentTimeMillis());
                    Integer.parseInt("a");
                }
            }
        }else{
            System.out.println("线程B 运行时间："+System.currentTimeMillis());
        }
    }
}
