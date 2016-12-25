package com.xc.thread.demo;

/**
 * 本类作为一个模拟Servlet组件，用来演示非线程安全问题
 */
public class LoginServlet {
    private static String usernameRef="zxc";
    private static String passwordRef="zxc";

//    public synchronized static void doPost(String username,String password){
    public static void doPost(String username,String password){
        try {
            synchronized(LoginServlet.class){
                usernameRef=username;
                if ("asd".equals(usernameRef)){
                    Thread.sleep(5000);
                }
                passwordRef=password;
                System.out.println(Thread.currentThread().getName()+"\tusername="+usernameRef+"\tpassword="+passwordRef);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }

//    public synchronized void getValue(){
    public void getValue(){
        synchronized(LoginServlet.class){
            System.out.println(Thread.currentThread().getName()+"\tusername="+usernameRef+"\tpassword="+passwordRef);
        }
    }
}
