package com.xc.thread;

import com.xc.thread.demo.SynchronizedObject;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/15
 * Time: 14:10
 * To change this template use File | Settings | File Templates
 */
public class Thread18 extends Thread {
    private SynchronizedObject synchronizedObject;

    public Thread18(SynchronizedObject synchronizedObject){
        this.synchronizedObject=synchronizedObject;
    }

    @Override
    public void run() {
        synchronizedObject.pringString("zxc","zxc");
    }
}
