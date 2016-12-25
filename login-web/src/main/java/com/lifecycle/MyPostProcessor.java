package com.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * Created by IntelliJ IDEA
 * User: lenovo
 * Date: 2016/5/24
 * Time: 23:32
 * To change this template use File | Settings | File Templates
 */
public class MyPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    //实例化Bean前调用此方法
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if("beanLife".equals(beanName)){
            System.out.println("实例化Bean前调用InstantiationAwareBeanPostProcessor的postProcessBeforeInstantiation()方法");
        }
        return null;
    }

    //实例化Bean后调用此方法
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if("beanLife".equals(beanName)){
            System.out.println("实例化Bean后调用InstantiationAwareBeanPostProcessor的postProcessAfterInstantiation()方法");
        }
        return true;
    }

    //设置Bean的属性值时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if("beanLife".equals(beanName)){
            System.out.println("设置Bean的属性值时调用InstantiationAwareBeanPostProcessor的postProcessPropertyValues()方法");
        }
        return pvs;
    }
}
