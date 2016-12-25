package com.xc.thread;

/**
 * 留意i--与System.out.println()的异常
 */
public class Thread6 extends Thread {
    private int i=5;

    /**
     * 测试目的：虽然println()方法在内部是同步的，但i--操作却是在进入println()之前发生的，所以有发生非线程安全问题的概率
     */
    @Override
    public void run() {
        System.out.println("i="+i--+"   当前线程为："+Thread.currentThread().getName());
    }
}
