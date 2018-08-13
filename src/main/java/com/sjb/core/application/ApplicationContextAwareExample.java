package com.sjb.core.application;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by simjunbo on 2018-08-09.
 */
public class ApplicationContextAwareExample implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        System.out.println("ApplicationContextAware");
        //Sample sample = (Sample) context.getBean("sample");
        //sample.test();
    }
}

