package com.reflect.fileresource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lenovo on 2016/4/25.
 */
public class TestResource {

    public static void main(String[] args) {
//        testFileAndClassRead();
        testFileUtils();
    }

    public static void testFileAndClassRead(){
        try{
            //①使用系统文件路径方式加载
            String filePath="D:\\workspring\\spring-3.x\\login-web\\target\\classes\\spring-mvc.xml";
            Resource fileResource=new FileSystemResource(filePath);

            //②使用类路径方式加载文件
            Resource classResource=new ClassPathResource("spring-mvc.xml");

            InputStream fileStream=fileResource.getInputStream();
            InputStream classStream=classResource.getInputStream();

            System.out.println("fileResource："+fileResource.getFilename());
            System.out.println("fileDescription："+fileResource.getDescription());
            System.out.println("classResource："+classResource.getFilename());
            System.out.println("classDescription："+classResource.getDescription());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void testFileUtils(){
        try {
            Resource classResource=new ClassPathResource("spring-mvc.xml");
            EncodedResource encRes=new EncodedResource(classResource,"UTF-8");
            String content= FileCopyUtils.copyToString(encRes.getReader());
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
