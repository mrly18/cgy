package com.xc.service.impl;

import com.xc.service.LookUpService1;
import com.xc.service.LookUpService2;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/2/17
 * Time: 20:28
 * To change this template use File | Settings | File Templates
 */
public abstract class LookUpService1Impl implements LookUpService1 {

    public LookUpService1Impl(){
        System.out.println("实例化抽象bean");
    }

    public abstract LookUpService1 getBean();

    public abstract LookUpService2 getBean2();

    /**
     * 测试当一个单例bean依赖一个prototype类型的bean时，比如英雄血量，就可以使用这种方式
     */
    @Override
    public void say() {
        System.out.println("*******"+getBean());
        System.out.println("抽象类说点什么");
        getBean().say();
        System.out.println("**********************");
    }

    public void fly() {
        System.out.println("*******"+getBean2());
        System.out.println("抽象类飞点什么");
        getBean2().fly();
        System.out.println("**********************");
    }
}
