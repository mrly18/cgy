package com.xc.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/9
 * Time: 15:11
 * To change this template use File | Settings | File Templates
 */
@Service
public class TestProxyCglib implements MethodInterceptor {
    private Enhancer enhancer=new Enhancer();

    /**
     * 拦截所有目标类方法的调用
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理类，调用目标对象方法前-> before");

        Object result=methodProxy.invokeSuper(obj,args);

        System.out.println("cglib代理类，调用目标对象方法后-> after");

        return result;
    }

    /**
     * 获取代理类
     */
    public Object getProxy(Class clazz){
        //设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }
}
