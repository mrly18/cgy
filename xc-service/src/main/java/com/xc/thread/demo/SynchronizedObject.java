package com.xc.thread.demo;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/15
 * Time: 14:03
 * To change this template use File | Settings | File Templates
 */
public class SynchronizedObject {
    private String name="asd";
    private String password="asd";

    public synchronized void pringString(String username,String password){
        try{
            this.name=username;
            Thread.sleep(8000);
            this.password=password;
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
