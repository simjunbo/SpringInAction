package com.sjb.core.application;

/**
 * Created by simjunbo on 2018-08-09.
 */
public class Sample {
    public void test() {
        System.out.println("ApplicationContextAware");
    }

    public void test2() {
        System.out.println("BeanPostProcessor : postProcessBeforeInitialization");
    }

    public void test3() {
        System.out.println("BeanPostProcessor : postProcessAfterInitialization");
    }
}
