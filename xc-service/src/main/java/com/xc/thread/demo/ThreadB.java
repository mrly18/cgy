package com.xc.thread.demo;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/24
 * Time: 14:35
 * To change this template use File | Settings | File Templates
 */
public class ThreadB extends Thread {
    private ThreadSafeVariable threadSafeVariable;
    public ThreadB(ThreadSafeVariable threadSafeVariable){
        this.threadSafeVariable=threadSafeVariable;
    }

    private ThreadUnsafeVariable threadUnsafeVariable;
    public ThreadB(ThreadUnsafeVariable threadUnsafeVariable){
        this.threadUnsafeVariable=threadUnsafeVariable;
    }

    @Override
    public void run() {
        if(null!=threadSafeVariable)
            threadSafeVariable.add("b");
        if(null!=threadUnsafeVariable)
            threadUnsafeVariable.add("b");
    }
}
