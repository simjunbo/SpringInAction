package com.sjb.core.application;

import org.springframework.beans.factory.BeanClassLoaderAware;

/**
 * Created by simjunbo on 2018-08-09.
 */
public class BeanClassLoaderAwareExample implements BeanClassLoaderAware {
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("BeanClassLoaderAware : "+classLoader.getParent());
    }
}
