package com.xc.thread;

import com.xc.thread.demo.LoginServlet;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/3/14
 * Time: 15:45
 * To change this template use File | Settings | File Templates
 */
public class BLogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("zxc","zxc");
    }
}
