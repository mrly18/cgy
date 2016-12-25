package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/21
 * Time: 18:13
 * To change this template use File | Settings | File Templates
 */
public class Thread20 extends Thread {
    private int i=0;

    @Override
    public void run() {
        while(true){
            i++;
        }
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
