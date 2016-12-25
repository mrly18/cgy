package com.lifecycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by IntelliJ IDEA
 * User: lenovo
 * Date: 2016/5/25
 * Time: 22:30
 * To change this template use File | Settings | File Templates
 */
public class Test {
    public static void main(String[] args) {
        testLife();
    }

    public static void testLife(){
        //装载配置文件并启动容器
        Resource resource=new ClassPathResource("spring-beanfactory.xml");
        BeanFactory beanFactory=new XmlBeanFactory(resource);

        //向容器中注册MyBeanPostProcessor后处理器
        //注：后处理器的调用顺序与注册顺序无关
        ConfigurableBeanFactory configurableBeanFactory=(ConfigurableBeanFactory)beanFactory;
        configurableBeanFactory.addBeanPostProcessor(new MyBeanPostProcessor());

        //向容器中注册InstantiationAwareBeanPostProcessor后处理器
        configurableBeanFactory.addBeanPostProcessor(new MyPostProcessor());

        //第一次从容器中获取BeanLife，将触发容器实例化该bean，这将引发Bean生命周期方法的调用
        BeanLife beanLife=beanFactory.getBean(BeanLife.class);//按类型获取
        System.out.println(beanLife);
        beanLife.setColor("绿色");

        //第二次从容器中获取beanLife，直接从缓存池中获取
        BeanLife beanLife2=beanFactory.getBean("beanLife",BeanLife.class);//按名称获取

        //查看2个bean是否指向同一引用
        System.out.println("bean1==bean2? "+(beanLife==beanLife2));

        //关闭容器
        ((XmlBeanFactory)beanFactory).destroySingletons();

    }
}
