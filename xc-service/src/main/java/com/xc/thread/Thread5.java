package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/11
 * Time: 18:03
 * To change this template use File | Settings | File Templates
 */
public class Thread5 extends Thread {
    private int count=5;

    /**
     * synchronized可以在任意对象及方法上加锁，而加锁的这段代码称为“互斥区”或“临界区”
     */
    @Override
    public synchronized void run() {
        super.run();
        System.out.println("当前线程："+Thread.currentThread().getName()+"，count="+count);
        this.count--;
    }
}
