package com.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by IntelliJ IDEA
 * User: lenovo
 * Date: 2016/5/24
 * Time: 23:49
 * To change this template use File | Settings | File Templates
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if("beanLife".equals(s)){
            BeanLife beanLife=(BeanLife)o;
            if(beanLife.getColor()==null){
                System.out.println("实例化前调用BeanPostProcessor的postProcessBeforeInitialization()方法");
                beanLife.setColor("蓝色");
            }
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if("beanLife".equals(s)){
            BeanLife beanLife=(BeanLife)o;
            if(!"2".equals(beanLife.getPeriod())){
                System.out.println("实例化后调用BeanPostProcessor的postProcessAfterInitialization()方法");
                beanLife.setPeriod("2");
            }
        }
        return o;
    }
}
