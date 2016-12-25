package com.xc.thread.demo;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/25
 * Time: 11:02
 * To change this template use File | Settings | File Templates
 */
public class SubChild extends Parent {

    public synchronized void subPrint(){
        try{
            while(i>0){
                System.out.println("SubChild 打印 i="+i);
                i--;
                Thread.sleep(100);
                this.print();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void serviceMethod() {
        try{
            System.out.println("子类下一步进入睡眠，线程名："+Thread.currentThread().getName()+" 时间："+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("子类睡眠结束，线程名："+Thread.currentThread().getName()+" 时间："+System.currentTimeMillis());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void synMethod1(){
        try{
            synchronized(this){
                System.out.println("A开始时间："+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A结束时间："+System.currentTimeMillis());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void synMethod2(){
        try{
            synchronized(this){
                System.out.println("B开始时间："+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("B结束时间："+System.currentTimeMillis());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public synchronized void synMethod3(){
        try{
            synchronized(this){
                System.out.println("C开始时间："+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("C结束时间："+System.currentTimeMillis());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
