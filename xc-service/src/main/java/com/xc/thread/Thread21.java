package com.xc.thread;

import com.xc.thread.demo.MyList;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/4/1
 * Time: 16:57
 * To change this template use File | Settings | File Templates
 */
public class Thread21 extends Thread {
    private MyList myList;

    public Thread21(MyList myList){
        super();
        this.myList=myList;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            myList.add();
            System.out.println(Thread.currentThread().getName()+"添加了 "+(i+1)+" 个元素");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
