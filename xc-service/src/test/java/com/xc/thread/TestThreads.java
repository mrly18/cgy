package com.xc.thread;

import com.xc.thread.demo.*;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/9
 * Time: 18:04
 * To change this template use File | Settings | File Templates
 */
public class TestThreads {

    public static void main(String[] args) {
//**************************第一章，基础知识********************************
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
//        test8();
//        test9();
//        test10();
//        test11();
//        test12();
//        test13();
//        test14();
//        test15();
//        test16();
//        test17();
//        test18();
//        test19();
//        test20();
//        test21();
//        test22();
//        test23();
//        test24();
//        test25();
//        test26();
//        test27();
//        test28();
//        test29();
//        test30();
//**************************第二章，对象及变量的并发访问********************************
//        test31();
//        test32();
//        test33();
//        test34();
//        test35();
//        test36();
//        test37();
//        test38();
//        test39();
//        test40();
//        test41();
//        test42();
//        test43();
//        test44();
//        test45();
//        test46();
//        test47();
//        test48();
//        test49();
//        test50();
//**************************第三章，线程间通信********************************
//        test51();
//        test52();
//        test53();
//        test54();
        test55();
        test56();
        test57();
        test58();
        test59();
        test60();
        test61();
        test62();
    }

    public static void test1(){
        Thread1 thread1=new Thread1();
        thread1.start();
        System.out.println(Thread.currentThread().getName()+"线程运行结束");
    }

    public static void test2(){//线程是随机执行的
        try {
            Thread2 thread2=new Thread2();
            thread2.setName("thread2");
            thread2.start();
            for (int i=0;i<10;i++){
                int time=(int)(Math.random()*1000);
                Thread.sleep(time);
                System.out.println("当前线程："+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void test3(){//start()方法不是顺序执行的
        Thread3 t1=new Thread3(1);
        Thread3 t2=new Thread3(2);
        Thread3 t3=new Thread3(3);
        Thread3 t4=new Thread3(4);
        Thread3 t5=new Thread3(5);
        Thread3 t6=new Thread3(6);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }

    public static void test4(){//实现Runnable的线程
        Runnable1 runnable1=new Runnable1();
        Thread t1=new Thread(runnable1);
        Thread t2=new Thread(runnable1,"r2");
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName()+"线程运行结束");
    }

    public static void test5(){//Thread构造方法可以传入Thread对象
        Thread0 t0=new Thread0(new Thread1());
        t0.start();
        Thread t=new Thread(new Thread1());
        System.out.println("*****************");
        t.start();
    }

    public static void test6(){//不共享变量的线程
        Thread4 t1=new Thread4("t1");
        Thread4 t2=new Thread4("t2");
        Thread4 t3=new Thread4("t3");
        t1.start();
        t2.start();
        t3.start();
    }

    public static void test7(){//共享变量的线程，run（）方法不加synchronized会出现非线程安全问题
        Thread5 thread5=new Thread5();
        Thread t1=new Thread(thread5,"t1");
        Thread t2=new Thread(thread5,"t2");
        Thread t3=new Thread(thread5,"t3");
        Thread t4=new Thread(thread5,"t4");
        Thread t5=new Thread(thread5,"t5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

    public static void test8(){//静态变量的非线程安全问题
        ALogin a=new ALogin();
        a.start();
        BLogin b=new BLogin();
        b.start();
    }

    public static void test9(){//非线程安全问题
        Thread6 thread6=new Thread6();
        Thread t1=new Thread(thread6);
        Thread t2=new Thread(thread6);
        Thread t3=new Thread(thread6);
        Thread t4=new Thread(thread6);
        Thread t5=new Thread(thread6);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    public static void test10(){//线程的构造方法是由main线程调用的---简单版
        Thread7 thread7=new Thread7();
        thread7.start();
    }

    public static void test11(){//线程的构造方法是由main线程调用的---复杂版
        Thread8 thread8=new Thread8();
        Thread thread=new Thread(thread8);
        thread.setName("A");
        thread.start();
    }

    public static void test12(){//isAlive()方法测试线程是否处于活动状态
        Thread9 thread9=new Thread9();
        System.out.println("start前："+thread9.isAlive());
        thread9.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("start后：" + thread9.isAlive());//start后isAlive()的值不确定，因为无法预知线程任务是否执行完
    }

    public static void test13(){//Thread.currentThread()和this的差异
        Thread10 thread10=new Thread10();
        Thread thread=new Thread(thread10);
        System.out.println("start前："+thread.isAlive());
        thread.setName("A");
        thread.start();
        System.out.println("start后："+thread.isAlive());
    }

    public static void test14(){//sleep()方法
        Thread11 thread11=new Thread11();
        System.out.println("begin="+System.currentTimeMillis());
//        thread11.run();
        thread11.start();
        System.out.println("  end="+System.currentTimeMillis());

    }

    public static void test15(){//interrupt()方法并不会停止线程，而是给线程打上一个停止的标记
        try {
            Thread12 thread12=new Thread12();
            thread12.start();
            Thread.sleep(1000);
            thread12.interrupt();
            Thread.currentThread().interrupt();//使main线程停止
//            System.out.println("是否停止1？=" + thread12.interrupted());//返回true，说明第一次使用interrupt()的确能使线程终止
//            System.out.println("是否停止2？="+thread12.interrupted());//返回false，因为一次调用interrupt()会清除中断状态
            System.out.println("是否停止1？=" + thread12.isInterrupted());//返回false
            System.out.println("是否停止2？=" + thread12.isInterrupted());//返回false，isInterrupted()不会清除状态标志
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /****************************从这里开始为停止线程的方法 begin********************************/

    public static void test16(){//抛出异常停止线程法--------------------->活动线程主动抛出异常
        try{
            Thread13 thread13=new Thread13();
            thread13.start();
            Thread.sleep(500);
            thread13.interrupt();
        }catch(InterruptedException e){

        }
    }

    /**
     * 先让thread14线程sleep，再去打断它
     * 在sleep()状态下停止线程法，当然自己不能打断自己，得由main线程打断---------->活动线程被动抛出异常
     * 这种情况要求打断时要在线程sleep时间内，即线程要睡得足够久
     */
    public static void test17(){
        try{
            Thread14 thread14=new Thread14();
            thread14.start();
            Thread.sleep(200);
    //在thread14调用sleep（）时，如果主线程调用thread14.interrupt()方法，在线程沉睡期间被打断，则线程会抛出异常，thread14被唤醒，不再中断
            thread14.interrupt();
        }catch(InterruptedException e){
            System.out.println("main catch");
            e.printStackTrace();
        }
    }

    /**
     * 先打断再去sleep，与test17()停止线程的方法刚好相反
     * 在线程已停止的情况下，去调用线程的sleep方法抛出异常，从而停止线程---------->活动线程被动抛出异常
     * 这种要求打断要在调sleep方法前，及线程执行程序时间到调用到sleep方法前，线程要被打断
     */
    public static void test18(){
        Thread15 thread15=new Thread15();
        thread15.start();
        thread15.interrupt();
    }

    public static void test19(){//使用stop方法暴力停止线程
        try{
            Thread16 thread16=new Thread16();
            thread16.start();
            Thread.sleep(5000);
            thread16.stop();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }

    public static void test20(){//stop方法主动捕获异常
        Thread17 thread17=new Thread17();
        thread17.start();
    }

    public static void test21(){//使用stop方法停止线程导致数据不一致的例子
        try{
            SynchronizedObject synchronizedObject=new SynchronizedObject();
            Thread18 thread18=new Thread18(synchronizedObject);
            thread18.start();
            Thread.sleep(500);
            thread18.stop();
            System.out.println(synchronizedObject.getName()+"\t"+synchronizedObject.getPassword());
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void test22(){//使用return配合interrupt来停止线程
        try{
            Thread19 thread19=new Thread19();
            thread19.start();
            Thread.sleep(500);
            thread19.interrupt();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /****************************从这里开始为停止线程的方法 end********************************/

    /****************************从这里开始为暂停线程的方法 begin********************************/

    /**
     * suspend()------暂停线程
     * resume()-------恢复线程
     */
    public static void test23(){
        try{
            Thread20 thread20=new Thread20();
            thread20.start();
            Thread.sleep(2000);
            //A段
            thread20.suspend();
            System.out.println("A=" + System.currentTimeMillis() + "    i=" + thread20.getI());
            Thread.sleep(2000);
            System.out.println("A=" + System.currentTimeMillis() + "    i=" + thread20.getI());
            //B段
            thread20.resume();
            Thread.sleep(2000);
            //C段
            thread20.suspend();
            System.out.println("B=" + System.currentTimeMillis() + "    i=" + thread20.getI());
            Thread.sleep(2000);
            System.out.println("B=" + System.currentTimeMillis() + "    i=" + thread20.getI());
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void test24(){//使用suspend造成的公共同步对象的独占示例
        try{
            final SynchronizedObject2 synchronizedObject2=new SynchronizedObject2();
            Thread thread1=new Thread(){
                @Override
                public void run() {
                    synchronizedObject2.printString();
                }
            };
            thread1.setName("a");
            thread1.start();
            Thread.sleep(1000);
            Thread thread2=new Thread(){
                @Override
                public void run() {
                    System.out.println("thread2启动了，但进不去printString方法，只打印一个begin");
                    System.out.println("因为printString方法被a线程锁定，并且永远暂停了");
                    synchronizedObject2.printString();
                }
            };
            thread2.start();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void test25(){//另一个独占的示例，暂停时，println（）内部的锁未被释放，所以主线程就打印不出来
        final SynchronizedObject2 synchronizedObject2=new SynchronizedObject2();
        Thread thread1=new Thread(){
            private int i=0;
            @Override
            public void run() {
                while(true){
                    i++;
                    synchronizedObject2.printString("a");
                    System.out.println(i);
                }
            }
        };
        thread1.start();
        try {
            Thread.sleep(10);
            thread1.suspend();
            System.out.println("main end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void test26(){//suspend方法与resume方法的缺点--------不同步
        final SuspendAndResume suspendAndResume=new SuspendAndResume();
        Thread thread1=new Thread("a"){
            @Override
            public void run() {
                suspendAndResume.setValue("a","aa");
            }
        };
        thread1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.resume();
        Thread thread2=new Thread(){
            @Override
            public void run() {
                suspendAndResume.printUsernamePassword();
            }
        };
        thread2.start();
    }

    /****************************从这里开始为暂停线程的方法 end********************************/

    /****************************从这里开始为yield方法 begin********************************/

    public static void test27(){//放弃cpu执行资源，但有可能会立马获得
        new Thread(){
            @Override
            public void run() {
                long beginTime=System.currentTimeMillis();
                int count=0;
                for(int i=1;i<50000;i++){
                    Thread.yield();
                    count+=i;
                }
                long endTime=System.currentTimeMillis();
                System.out.println("用时："+(endTime-beginTime)+" 毫秒");
            }
        }.start();
    }

    /****************************从这里开始为yield方法 end********************************/

    /****************************线程的优先级 begin********************************/

    public static void test28(){//线程优先级，优先级具有继承性，比如A线程启动了B线程，则B的优先级与A是一样的
        System.out.println("main的优先级："+Thread.currentThread().getPriority());
//        Thread.currentThread().setPriority(6);
        System.out.println("main的优先级："+Thread.currentThread().getPriority());
        final Thread thread1=new Thread(){
            @Override
            public void run() {
                System.out.println("thread1的优先级："+this.getPriority());
            }
        };

        Thread thread2=new Thread(){
            @Override
            public void run() {
                System.out.println("thread2的优先级："+this.getPriority());
                thread1.start();
            }
        };
        thread2.start();
    }

    public static void test29(){//设置优先级的效果,与在main线程中的执行顺序无关，优先级高的运行速度快
        for(int i=0;i<5;i++){
            Thread thread1=new Thread(){
                @Override
                public void run() {
                    long beginTime=System.currentTimeMillis();
                    int addResult=0;
                    for(int i=0;i<10;i++){
                        for(int j=0;j<50000;j++){
                            Random random=new Random();
                            random.nextInt();
                            addResult+=j;
                        }
                    }
                    long endTime=System.currentTimeMillis();
                    System.out.println("thread1耗时："+(endTime-beginTime));
                }
            };
            thread1.setPriority(10);
            thread1.start();

            Thread thread2=new Thread(){
                @Override
                public void run() {
                    long beginTime=System.currentTimeMillis();
                    int addResult=0;
                    for(int i=0;i<10;i++){
                        for(int j=0;j<50000;j++){
                            Random random=new Random();
                            random.nextInt();
                            addResult+=j;
                        }
                    }
                    long endTime=System.currentTimeMillis();
                    System.out.println("thread2耗时：" + (endTime - beginTime));
                }
            };
            thread2.setPriority(1);
            thread2.start();
        }
    }

    /****************************线程的优先级 end********************************/

    /****************************守护线程 begin********************************/

    public static void test30(){//创建守护线程
        Thread thread1=new Thread(){
            private int i=0;
            @Override
            public void run() {
                try{
                    while(true){
                        i++;
                        System.out.println("i="+i);
                        Thread.sleep(1000);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        };

        thread1.setDaemon(true);
        thread1.start();
        try {
            Thread.sleep(5000);
            System.out.println("我离开thread对象也不再打印了，也就是停止了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /****************************守护线程 end********************************/

    /****************************对象及变量的并发访问 begin********************************/

    /****************************synchronized同步方法 begin********************************/
    public static void test31(){//方法内部变量线程安全示例
        ThreadSafeVariable threadSafeVariable=new ThreadSafeVariable();
        ThreadA threadA=new ThreadA(threadSafeVariable);
        threadA.start();
        ThreadB threadB=new ThreadB(threadSafeVariable);
        threadB.start();
    }

    public static void test32(){//实例变量被多个线程访问的非线程安全示例
        ThreadUnsafeVariable threadUnsafeVariable=new ThreadUnsafeVariable();
        ThreadA threadA=new ThreadA(threadUnsafeVariable);
        threadA.start();
        ThreadB threadB=new ThreadB(threadUnsafeVariable);
        threadB.start();
    }

    public static void test33(){//多个对象多个锁
        ThreadA threadA=new ThreadA(new ThreadUnsafeVariable());
        threadA.start();
        ThreadB threadB=new ThreadB(new ThreadUnsafeVariable());
        threadB.start();
    }

    public static void test34(){//验证synchronized锁的是对象
        SynchronizedIsObject synchronizedIsObject=new SynchronizedIsObject();
        ThreadA1 threadA1=new ThreadA1(synchronizedIsObject);
        threadA1.start();
        ThreadB1 threadA2=new ThreadB1(synchronizedIsObject);
        threadA2.start();
    }

    public static void test35(){//对象中用synchronized修饰的方法，共用一把对象锁，但其他线程可以异步调用非synchronized方法
        SynchronizedIsObject synchronizedIsObject=new SynchronizedIsObject();
        ThreadA1 threadA1=new ThreadA1(synchronizedIsObject);
        threadA1.start();
        ThreadB1 threadB1=new ThreadB1(synchronizedIsObject);
        threadB1.start();
    }

    public static void test36(){//脏读，赋值同步，取值不同步导致脏读的例子,解决办法读的时候是加上同步锁
//        final DirtyRead loginServlet=new DirtyRead();
        final LoginServlet loginServlet=new LoginServlet();//实例锁对静态变量和静态方法不起作用，因为对象跟类是2个概念,锁住类就行了
        new Thread(){
            @Override
            public void run() {
                loginServlet.doPost("asd","asd");
            }
        }.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginServlet.getValue();
    }

    public static void test37(){//synchronized锁重入，当一个线程已经获取到锁之后，如果任务没结束，则可以继续获取内部锁
        new Thread(){
            @Override
            public void run() {
                SynchronizedAgainIn synchronizedAgainIn=new SynchronizedAgainIn();
                synchronizedAgainIn.service1();
            }
        }.start();
    }

    public static void test38() {//父子类的锁重入,子类可以在同步方法里调用父类的同步方法
        new Thread(){
            @Override
            public void run() {
                SubChild subChild=new SubChild();
                subChild.subPrint();
            }
        }.start();
    }

    public static void test39(){//出现异常时，锁自动释放
        final Service1 service1=new Service1();
        Thread thread1=new Thread(){
            @Override
            public void run() {
                service1.testMethod();
            }
        };
        thread1.setName("a");
        thread1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread2=new Thread(){
            @Override
            public void run() {
                service1.testMethod();
            }
        };
        thread2.setName("b");
        thread2.start();
    }

    public static void test40(){//同步不具有继承性,要想实现同步，还得在子类的方法上加上synchronized
        final SubChild subChild=new SubChild();
        Thread thread1=new Thread(){
            @Override
            public void run() {
                subChild.serviceMethod();
            }
        };
        thread1.setName("A");
        thread1.start();
        Thread thread2=new Thread(){
            @Override
            public void run() {
                subChild.serviceMethod();
            }
        };
        thread2.setName("B");
        thread2.start();
    }

    /****************************synchronized同步方法 end********************************/

    /****************************synchronized同步语句块 begin********************************/

    public static void test41(){//synchronized同步方法的弊端示例
        final SynMethodShort synMethodShort=new SynMethodShort();
        Thread thread1=new Thread(){
            @Override
            public void run() {
                CommonUtils.beginTime1=System.currentTimeMillis();
                synMethodShort.doLongTimeTask();
                CommonUtils.endTime1=System.currentTimeMillis();
            }
        };
        thread1.start();
        Thread thread2=new Thread(){
            @Override
            public void run() {
                CommonUtils.beginTime2=System.currentTimeMillis();
                synMethodShort.doLongTimeTask();
                CommonUtils.endTime2=System.currentTimeMillis();
            }
        };
        thread2.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long beginTime=CommonUtils.beginTime2<CommonUtils.beginTime1?CommonUtils.beginTime2:CommonUtils.beginTime1;
        long endTime=CommonUtils.endTime2>CommonUtils.endTime1?CommonUtils.endTime2:CommonUtils.endTime1;
        System.out.println("耗时："+(endTime-beginTime)/1000);
    }

    public static void test42(){//同步代码块锁的是对象，线程A占用对象的锁时，其他线程调用该对象的其他同步代码块需要等待
        final SubChild subChild=new SubChild();
        Thread thread1=new Thread(){
            @Override
            public void run() {
                subChild.synMethod1();
            }
        };
        thread1.setName("a");
        thread1.start();
        Thread thread2=new Thread(){
            @Override
            public void run() {
                subChild.synMethod3();
            }
        };
        thread2.setName("b");
        thread2.start();
    }

    public static void test43(){//synchronized(非this对象)，多线程调用同一对象的同步方法是一步的，不需要等待
        final SynNotThis synNotThis=new SynNotThis();
        new Thread(){
            @Override
            public void run() {
                synNotThis.test("a","aa");
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                synNotThis.test("b","bb");
            }
        }.start();
    }

    public static void test44(){//线程执行的随机性，没有什么特殊意义
        final MyList myList=new MyList();
        new Thread(){
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    myList.add("AA");
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for(int i=0;i<100;i++){
//                    myList.add("BB");
                    myList.getSize();
                }
            }
        }.start();
    }

    public static void test45(){//线程死锁
        DealThread dealThread=new DealThread();
        dealThread.setFlag("a");
        Thread thread1=new Thread(dealThread);
        thread1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dealThread.setFlag("b");
        Thread thread2=new Thread(dealThread);
        thread2.start();

    }

    public static void test46(){//内部类与静态内部类的同步实验1
        //内部类
        PublicClass publicClass=new PublicClass();
        PublicClass.PrivateClass privateClass=publicClass.new PrivateClass();
        //静态内部类
        final PublicClass2.PrivateClass2 privateClass2=new PublicClass2.PrivateClass2();

        new Thread("线程A"){
            @Override
            public void run() {
                privateClass2.method1();
            }
        }.start();
        new Thread("线程B"){
            @Override
            public void run() {
                privateClass2.method2();
            }
        }.start();
    }

    public static void test47(){//静态内部类的同步实验2
        final PublicClass2.InnerClass1 innerClass1=new PublicClass2.InnerClass1();
        final PublicClass2.InnerClass2 innerClass2=new PublicClass2.InnerClass2();
        new Thread("线程A"){
            @Override
            public void run() {
                innerClass1.method1(innerClass2);
            }
        }.start();
        new Thread("线程B"){
            @Override
            public void run() {
                innerClass1.method2();
            }
        }.start();
        new Thread("线程C"){
            @Override
            public void run() {
                innerClass2.method();
            }
        }.start();
    }

    public static void test48(){//锁对象的改变，以String对象为例，获取锁的对象是随机的
        final ChangeSyn changeSyn=new ChangeSyn();
        Thread thread1=new Thread("线程A"){
            @Override
            public void run() {
                changeSyn.testMethod();
            }
        };
        Thread thread2=new Thread("线程B"){
            @Override
            public void run() {
                changeSyn.testMethod();
            }
        };
        thread1.start();
//        try {
//            Thread.sleep(50);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        thread2.start();
    }

    public static void test49(){//解决异步死循环
        RunThread runThread=new RunThread();
        runThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runThread.setRunning(false);
        System.out.println("已经赋值为false");
    }

    public static void test50(){//使用原子类型保证同步性
        AtomicInteger atomicInteger=new AtomicInteger();
        atomicInteger.incrementAndGet();
    }

    /****************************synchronized同步语句块 end********************************/


    /****************************对象及变量的并发访问 end********************************/

    /****************************线程间通信 begin********************************/
    public static void test51(){//使用sleep（）结合while(true)死循环通信的例子
        final MyList myList=new MyList();
        Thread thread1=new Thread("A"){
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
        };
        thread1.start();
        Thread thread2=new Thread("B"){
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
        };
        thread2.start();
    }

    public static void test52(){//如果没有持有适当的锁，调用wait方法时，会抛出运行时异常java.lang.IllegalMonitorStateException
        String a="";
        System.out.println("begin");
        try {
            synchronized(a){
                System.out.println("同步代码块begin");
                a.wait();//调用完wait方法时，线程进入等待状态，并且线程程序的执行停在调用wait方法处
                System.out.println("同步代码块end");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }

    public static void test53(){//notify
        final String a="";
        new Thread("A线程"){
            @Override
            public void run() {
                try {
                    synchronized(a){
                        System.out.println(Thread.currentThread().getName()+"同步代码块begin");
                        a.wait();
                        System.out.println(Thread.currentThread().getName()+"同步代码块end");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread("B线程"){
            @Override
            public void run() {
                synchronized(a){
                    System.out.println(Thread.currentThread().getName()+"同步代码块begin");
                    a.notify();
                    System.out.println(Thread.currentThread().getName()+"同步代码块end");
                }
            }
        }.start();
    }

    public static void test54(){//使用wait、notify实现test51()
        final String a="";
        Thread thread1=new Thread("线程A"){
            @Override
            public void run() {
                synchronized(a){
                    for(int i=0;i<10;i++){
                        MyList.addNotify();
                        System.out.println(Thread.currentThread().getName()+"添加了 "+(i+1)+" 个元素");
                        if(MyList.sizeWait()==5){
                            System.out.println(Thread.currentThread().getName()+"等于5，发出通知了");
                            a.notify();
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread thread2=new Thread("线程B"){
            @Override
            public void run() {
                try {
                    synchronized(a){
                        if(MyList.sizeWait()!=5){
                            System.out.println(Thread.currentThread().getName()+"进入wait，时间1="+System.currentTimeMillis());
                            a.wait();
                            System.out.println(Thread.currentThread().getName()+"离开wait，时间2="+System.currentTimeMillis());
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread2.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();
    }

    public static void test55(){}

    public static void test56(){}

    public static void test57(){}

    public static void test58(){}

    public static void test59(){}

    public static void test60(){}

    public static void test61(){}

    public static void test62(){}

    /****************************线程间通信 end********************************/


}
