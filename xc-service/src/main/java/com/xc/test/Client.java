package com.xc.test;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/29
 * Time: 18:33
 * To change this template use File | Settings | File Templates
 */
public class Client {
    public static void main(String[] args){
        String filePath = "D:\\日志\\testInput.txt";

        AprioriTool tool = new AprioriTool(filePath, 2);
        tool.printAttachRule(0.7);
    }
}
