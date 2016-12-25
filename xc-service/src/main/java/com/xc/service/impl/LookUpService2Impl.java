package com.xc.service.impl;

import com.xc.service.LookUpService1;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/2/17
 * Time: 20:28
 * To change this template use File | Settings | File Templates
 */
@Service
public class LookUpService2Impl implements LookUpService1 {

    public LookUpService2Impl(){
        System.out.println("实例化依赖bean");
    }

    @Override
    public void say() {
        System.out.println("2说点什么");
    }
}
