package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/15
 * Time: 13:35
 * To change this template use File | Settings | File Templates
 */
public class Thread16 extends Thread {
    private int i=0;

    @Override
    public void run() {
        try{
            while(true){
                System.out.println("i="+(++i));
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
