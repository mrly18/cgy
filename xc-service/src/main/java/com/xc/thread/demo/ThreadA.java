package com.xc.thread.demo;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/24
 * Time: 14:35
 * To change this template use File | Settings | File Templates
 */
public class ThreadA extends Thread {
    private ThreadSafeVariable threadSafeVariable;
    public ThreadA(ThreadSafeVariable threadSafeVariable){
        this.threadSafeVariable=threadSafeVariable;
    }

    private ThreadUnsafeVariable threadUnsafeVariable;
    public ThreadA(ThreadUnsafeVariable threadUnsafeVariable){
        this.threadUnsafeVariable=threadUnsafeVariable;
    }

    @Override
    public void run() {
        if(null!=threadSafeVariable)
            threadSafeVariable.add("a");
        if(null!=threadUnsafeVariable)
            threadUnsafeVariable.add("a");
    }
}
