package com.xc.thread.demo;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/4/1
 * Time: 10:27
 * To change this template use File | Settings | File Templates
 */
public class RunThread extends Thread {
    private boolean isRunning=true;

    @Override
    public void run() {
        System.out.println("进入了run方法");
        while(isRunning){

        }
        System.out.println("离开了run方法");
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
}
