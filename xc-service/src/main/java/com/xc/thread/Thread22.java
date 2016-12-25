package com.xc.thread;

import com.xc.thread.demo.MyList;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/4/1
 * Time: 16:59
 * To change this template use File | Settings | File Templates
 */
public class Thread22 extends Thread {
    private MyList myList;

    public Thread22(MyList myList){
        super();
        this.myList=myList;
    }

    @Override
    public void run() {
        try {
            while(true){
                if(myList.size()==5){
                            System.out.println("==5了，线程 B 要退出了");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
