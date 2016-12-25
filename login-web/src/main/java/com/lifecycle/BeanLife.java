package com.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * 管理Bean的生命周期-Bean级接口
 */
public class BeanLife implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean {
    private String lifeName;
    private String period;
    private String color;

    private BeanFactory beanFactory;
    private String beanName;

    public BeanLife(){
        System.out.println("调用BeanLife的无参构造方法");
    }

    @Override
    public String toString() {
        return "lifeName："+this.lifeName+"，period："+this.period+"，color："+this.color;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware的setBeanFactory()方法");
        this.beanFactory=beanFactory;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("调用BeanNameAware的setBeanName()方法");
        this.beanName=beanName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean的afterPropertiesSet()方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean的destroy()方法");
    }

    public void myInit(){
        System.out.println("调用<bean/>节点指定的init-method方法");
        this.period="myInit()";
    }

    public void myDestory(){
        System.out.println("调用<bean/>节点指定的destory-method方法");
    }

    public void setLifeName(String lifeName) {
        System.out.println("调用BeanLife的setLifeName()设置lifeName属性值");
        this.lifeName = lifeName;
    }

    public String getLifeName() {
        return lifeName;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        System.out.println("调用BeanLife的setPeriod()设置period属性值");
        this.period = period;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        System.out.println("调用BeanLife的setColor()设置color属性值");
        this.color = color;
    }
}
