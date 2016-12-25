package com.xc.thread.demo;

/**
 * 本类作为一个模拟Servlet组件，用来演示非线程安全问题
 */
public class DirtyRead {
    private String usernameRef="zxc";
    private String passwordRef="zxc";

    public synchronized void doPost(String username,String password){
        try {
            usernameRef=username;
            if ("asd".equals(usernameRef)){
                Thread.sleep(5000);
            }
            passwordRef=password;
            System.out.println(Thread.currentThread().getName()+"\tusername="+usernameRef+"\tpassword="+passwordRef);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }

    public synchronized void getValue(){
        System.out.println(Thread.currentThread().getName()+"\tusername="+usernameRef+"\tpassword="+passwordRef);
    }
}
