package com.xc.service.impl;

import com.xc.service.LookUpService2;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/2/18
 * Time: 9:58
 * To change this template use File | Settings | File Templates
 */
public class LookUpService3Impl implements LookUpService2 {
    @Override
    public void fly() {
        System.out.println("依赖bean的飞");
    }
}
