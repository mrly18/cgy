package com.xc.test;

import com.xc.web.TestWeb;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/2/3
 * Time: 13:38
 * To change this template use File | Settings | File Templates
 */
@ContextConfiguration("classpath:spring-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSpring {

    @Autowired
    TestWeb testWeb;

    @Test
    public void test1(){
        System.out.println("name:"+testWeb.getName());
        System.out.println("age:"+testWeb.getAge());
        testWeb.setAge(15);
        Assert.assertEquals("Tom",testWeb.getName());
    }

    @Test
    public void test2(){
        Assert.assertEquals(26,testWeb.getAge());
    }

    @Test
    public void test3(){
        System.out.println("name:"+testWeb.getName());
        System.out.println("age:"+testWeb.getAge());
        Assert.assertEquals("noah",testWeb.getName());
    }

}
