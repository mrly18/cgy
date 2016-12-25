package com.xc.thread;

/**
 * 不共享实例的线程
 */
public class Thread4 extends Thread {
    private int count=5;

    public Thread4(String name){
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count>0){
            System.out.println("当前线程："+Thread.currentThread().getName()+"，count="+count);
            count--;
        }
    }
}
