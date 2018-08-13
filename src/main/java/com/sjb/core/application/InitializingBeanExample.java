package com.sjb.core.application;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by simjunbo on 2018-08-13.
 */
public class InitializingBeanExample implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean");
    }
}
