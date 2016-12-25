package com.xc.test;

import com.test.domain.Domain1;
import com.test.domain.Domain2;
import com.xc.common.CommonBean1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/2/4
 * Time: 15:53
 * To change this template use File | Settings | File Templates
 */
@ContextConfiguration("classpath:spring-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDomain {

    @Autowired
    Domain1 domain1;

    @Autowired
    Domain2 domain2;

    @Autowired
    CommonBean1 commonBean1;

    @Test
    public void test1(){
        String name1=domain1.getCommonBean1().getName();
        System.out.println("domain1的commonDomain的名字是："+name1);
        domain1.getCommonBean1().setName("qq");
        String name2=domain2.getCommonBean1().getName();
        System.out.println("domain2的commonDomain的名字是："+name2);
        System.out.println(domain1.getCommonBean1()==domain2.getCommonBean1());
        Assert.assertEquals("我的名字是CommonBean1",name1);
    }

    @Test
    public void test2(){
        String name2=domain2.getCommonBean1().getName();
        System.out.println("domain2的commonDomain的名字是："+name2);
        Assert.assertEquals("我的名字是CommonBean1",name2);
    }
}
