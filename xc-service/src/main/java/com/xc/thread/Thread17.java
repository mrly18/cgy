package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/15
 * Time: 13:47
 * To change this template use File | Settings | File Templates
 */
public class Thread17 extends Thread {
    /**
     * stop方法的异常一般不需要显示捕捉，如果捕捉了，则会捕捉到异常
     * 这里会抛出异常是因为stop方法已作废，如果强制让线程停止，则有可能使一些请理性的工作得不到完成
     * 另外一种情况就是对锁定的对象进行了”解锁“，导致数据得不到同步的处理，出现数据不一致的问题
     */
    @Override
    public void run() {
        try{
            this.stop();
        }catch (ThreadDeath e){
            System.out.println("进入run的catch");
            e.printStackTrace();
        }
    }
}
