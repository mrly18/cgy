package com.xc.annotation;

import com.test.domain.Domain3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

/**
 * 测试@Required注解
 */
public class RequiredTest {
    private Domain3 domain3;

    public Domain3 getDomain3() {
        return domain3;
    }

    /*@Required
    public void setDomain3(Domain3 domain3) {
        this.domain3 = domain3;
    }*/

    /*@Autowired
    public void setDomain3(Domain3 domain3) {
        this.domain3 = domain3;
    }*/

    @Autowired
    public void setDomain3(@Qualifier("do3")Domain3 domain3) {
        this.domain3 = domain3;
    }
}
