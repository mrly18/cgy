package com.xc.test;

import com.xc.service.impl.LookUpService1Impl;
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
public class TestLookUp {

    @Autowired
    LookUpService1Impl lookUpService1Impl;

    @Test
    public void test1(){
        lookUpService1Impl.fly();
        lookUpService1Impl.fly();
    }


}
