package com.xc.thread.demo;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/24
 * Time: 14:18
 * To change this template use File | Settings | File Templates
 */
public class ThreadUnsafeVariable {
    private int num=0;
    public synchronized void add(String username){
        try {
            if("a".equals(username)){
                num=100;
                System.out.println("a set over");
                Thread.sleep(2000);
            }else{
                num=200;
                System.out.println("b set over");
            }
            System.out.println(username+"\tnum="+num);
        }catch (Exception e){

        }
    }
}
