package com.xc.thread.demo;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/30
 * Time: 10:40
 * To change this template use File | Settings | File Templates
 */
public class SynNotThis {
    private String name;
    private String password;
    private String any=new String();

    public void test(String name,String password){
        try{
            String any2=new String();
            synchronized(any2){
                this.name=name;
                System.out.println(Thread.currentThread().getName()+"\tname="+this.name);
                Thread.sleep(3000);
                this.password=password;
                System.out.println(Thread.currentThread().getName()+"\tpassword="+this.password);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
