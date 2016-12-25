package com.xc.thread.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/30
 * Time: 11:49
 * To change this template use File | Settings | File Templates
 */
public class MyList {
    private List list=new Vector();
    private static List list2=new Vector();

    public synchronized void add(String name){
        System.out.println(Thread.currentThread().getName()+"\t"+name+"\t执行了add方法");
        list.add(name);
        System.out.println(Thread.currentThread().getName() + "\t" + name + "\t退出了add方法");
    }

    public synchronized void getSize(){
        System.out.println(Thread.currentThread().getName()+"\t执行了getSize方法");
        System.out.println(Thread.currentThread().getName()+"\t退出了getSize方法，size大小为："+list.size());
    }

    public void add(){
        list.add("cgy");
    }

    public int size(){
        return list.size();
    }

    public static void addNotify(){
        list2.add("cgy");
    }

    public static int sizeWait(){
        return list2.size();
    }
}
