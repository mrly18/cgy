package com.test.domain;

import com.xc.common.CommonBean1;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA
 * User: caogongyuan
 * Date: 2016/2/4
 * Time: 15:34
 * To change this template use File | Settings | File Templates
 */
@Service
public class Domain2 {
    private String name;

    private CommonBean1 commonBean1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommonBean1 getCommonBean1() {
        return commonBean1;
    }

    public void setCommonBean1(CommonBean1 commonBean1) {
        this.commonBean1 = commonBean1;
    }
}
