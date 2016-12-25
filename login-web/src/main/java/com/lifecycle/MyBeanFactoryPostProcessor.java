package com.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by IntelliJ IDEA
 * User: lenovo
 * Date: 2016/5/25
 * Time: 23:50
 * To change this template use File | Settings | File Templates
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition beanDefinition=configurableListableBeanFactory.getBeanDefinition("beanLife");
        beanDefinition.getPropertyValues().addPropertyValue("color","彩色");
        System.out.println("调用BeanFactoryPostProcessor的postProcessBeanFactory()方法");
    }
}
