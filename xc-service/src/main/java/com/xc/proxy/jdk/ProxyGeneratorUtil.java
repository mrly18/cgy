package com.xc.proxy.jdk;

import com.xc.service.impl.UserServiceImpl;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 代理类的生成工具，为了查看JDK动态代理生成的是什么样的东西
 */
public class ProxyGeneratorUtil {

    /**
     * 把代理类的字节码写到磁盘上
     * @param path
     */
    public static void writeProxyClassToHardDisk(String path){
        //获取代理类的字节码
        byte[] classFile= ProxyGenerator.generateProxyClass("daililei", UserServiceImpl.class.getInterfaces());
        FileOutputStream out=null;
        try {
            out=new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
