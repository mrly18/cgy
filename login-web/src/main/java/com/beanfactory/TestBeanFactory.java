package com.beanfactory;

import com.reflect.domain.People;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA
 * User: lenovo
 * Date: 2016/4/28
 * Time: 23:30
 * To change this template use File | Settings | File Templates
 */
public class TestBeanFactory {
    public static void main(String[] args) {
        testXmlBean();
    }

    /**
     * 通过XmlBeanFactory实现类启动SpringIoC容器
     */
    public static void testXmlBean(){
        ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        Resource resource=resolver.getResource("classpath:spring-beanfactory.xml");
        BeanFactory bf=new XmlBeanFactory(resource);
        People p1=bf.getBean("p1",People.class);//<T> T getBean(String var1,Class<T> var2)
        People p2= (People) bf.getBean("p1");//Object getBean(String var1)
        System.out.println(p1.getName());
        System.out.println("如果People无参构造方法只被调用了一次，说明spring对单例模式做了缓存");
    }
}
