package com.xc.thread;

/**
 * 子类无论是使用有参构造函数或者无参构造函数创建，都会默认执行父类无参构造函数，除非显示执行父类的有参构造函数
 */
public class Student extends Teacher {

    public Student(String name){
//        super("");
        System.out.println("我是学生");
    }


    @Override
    public void say() {
//        super.say();
        System.out.println("我是学生say");
    }

    public static void main(String[] args) {
        Student student=new Student("");
        student.say();
    }
}
