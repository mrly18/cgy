package com.xc.thread;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/15
 * Time: 10:22
 * To change this template use File | Settings | File Templates
 */
public class Thread13 extends Thread {
    @Override
    public void run() {
        try{
            for(int i=0;i<100000;i++){
                if(this.interrupted()){
                    System.out.println("已经是停止状态，我要退出了");
//                break;//使用break并不能使线程停止后面的执行
                    throw new InterruptedException();
                }
                System.out.println("i="+(i+1));
            }
            System.out.println("虽然退出了，但for语句后面的仍能执行");
        }catch(InterruptedException e){
            System.out.println("抛出异常停止线程");
            e.printStackTrace();
        }
    }
}
