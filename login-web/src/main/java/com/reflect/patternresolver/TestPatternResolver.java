package com.reflect.patternresolver;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA
 * User: lenovo
 * Date: 2016/4/27
 * Time: 23:20
 * To change this template use File | Settings | File Templates
 */
public class TestPatternResolver {
    public static void main(String[] args) {
        try {
            ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
            //①加载所有类包下的以xml为后缀的资源
            Resource[] resources=resolver.getResources("classpath*:**/*.xml");
            for(Resource r:resources){
                System.out.println(r.getDescription());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
