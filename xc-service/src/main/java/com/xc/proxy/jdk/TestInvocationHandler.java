package com.xc.proxy.jdk;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 */
@Service
public class TestInvocationHandler implements InvocationHandler {
    //目标对象
    private Object target;

    /**
     * 构造方法
     */
    public TestInvocationHandler(Object target){
        super();
        this.target=target;
    }

    /**
     * 执行目标对象的方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk动态代理，执行目标方法前-> before");

        //执行目标对象的方法
        Object result=method.invoke(this.target,args);

        System.out.println("jdk动态代理，执行目标方法后-> after");

        return result;
    }

    /**
     * 获取目标对象的代理对象
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                this.target.getClass().getInterfaces(),this);
    }


}
