package com.xc.thread.demo;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/23
 * Time: 15:36
 * To change this template use File | Settings | File Templates
 */
public class SuspendAndResume {
    private String username="1";
    private String password="11";

    public void setValue(String u,String p){
        this.username=u;
        if("a".equals(Thread.currentThread().getName())){
            System.out.println("暂停线程a");
            Thread.currentThread().suspend();
        }
        this.password=p;
    }

    public void printUsernamePassword(){
        System.out.println(username+"\t"+password);
    }

}
