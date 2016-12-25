package com.xc.thread.demo;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/31
 * Time: 13:29
 * To change this template use File | Settings | File Templates
 */
public class PublicClass2 {
    private static String name;
    private static String password;

    public static class PrivateClass2{
        private int age;
        private String address;

        public void method1(){
            synchronized("其他的锁"){
                for(int i=1;i<=10;i++){
                    System.out.println(Thread.currentThread().getName()+"\ti="+i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public synchronized void method2(){
            for(int i=1;i<11;i++){
                System.out.println(Thread.currentThread().getName()+"\ti="+i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    public static class InnerClass1{
        public void method1(InnerClass2 class2){
            synchronized(class2){
                System.out.println(Thread.currentThread().getName()+"\t进入InnerClass1中的method1方法");
                for(int i=1;i<=10;i++){
                    System.out.println(Thread.currentThread().getName()+"\ti="+i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"\t离开InnerClass1中的method1方法");
            }
        }

        public synchronized void method2(){
            System.out.println(Thread.currentThread().getName()+"\t进入InnerClass1中的method2方法");
            for(int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+"\ti="+i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"\t离开InnerClass1中的method2方法");
        }
    }

    public static class InnerClass2{
        public synchronized void method(){
            System.out.println(Thread.currentThread().getName()+"\t进入InnerClass2中的method方法");
            for(int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+"\ti="+i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"\t离开InnerClass2中的method方法");
        }
    }
}
