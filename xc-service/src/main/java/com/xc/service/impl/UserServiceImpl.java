package com.xc.service.impl;

import com.xc.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 动态代理的目标对象
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("调用JDK动态代理的目标对象的方法-> UserServiceImpl.add()");
    }
}
