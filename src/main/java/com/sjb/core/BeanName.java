package com.sjb.core;

import org.springframework.beans.factory.BeanNameAware;

/**
 * Created by simjunbo on 2018-08-09.
 */
public class BeanName implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware : " + name);
    }
}
