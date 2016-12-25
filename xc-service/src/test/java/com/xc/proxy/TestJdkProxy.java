package com.xc.proxy;

import com.xc.proxy.cglib.NormalClass;
import com.xc.proxy.cglib.TestProxyCglib;
import com.xc.proxy.jdk.ProxyGeneratorUtil;
import com.xc.proxy.jdk.TestInvocationHandler;
import com.xc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Proxy;

/**
 * 测试JDK动态代理
 */
@ContextConfiguration("classpath:spring-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJdkProxy {
    @Autowired
    TestInvocationHandler testInvocationHandler;

    @Autowired
    TestProxyCglib testProxyCglib;

    /**
     * 测试动态代理
     */
    @Test
    public void testProxy(){
        //根据目标对象生成代理对象
        UserService proxyUserService=(UserService)testInvocationHandler.getProxy();
        if(proxyUserService instanceof Proxy&&proxyUserService instanceof UserService){
            System.out.println("是代理类的实例");
        }
        //调用代理对象的方法
        proxyUserService.add();

    }

    /**
     * 测试动态代理类的字节码文件
     */
    @Test
    public void testGenerateProxyClass(){
        ProxyGeneratorUtil.writeProxyClassToHardDisk("D:/动态代理类字节码/daililei.class");
    }

    /**
     * 测试cglib动态代理
     */
    @Test
    public void testCglibProxy(){
        NormalClass normalClass=(NormalClass)testProxyCglib.getProxy(NormalClass.class);
        normalClass.say();
    }
}
