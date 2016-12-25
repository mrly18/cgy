package com.xc.annotation;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/7
 * Time: 20:53
 * To change this template use File | Settings | File Templates
 */
@ContextConfiguration("classpath:spring-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAnnotation {
    @Autowired
    RequiredTest requiredTest;

    @Test
    public void test1(){
        Assert.assertEquals("lucy",requiredTest.getDomain3().getName());
    }
}
