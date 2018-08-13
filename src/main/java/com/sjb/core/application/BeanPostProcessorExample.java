package com.sjb.core.application;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by simjunbo on 2018-08-09.
 */
public class BeanPostProcessorExample implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("initializingBean".equals(beanName)){
            System.out.println("BeanPostProcessor - postProcessBeforeInitialization");
/*            Sample sample = (Sample) bean;
            sample.test2();*/
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("initializingBean".equals(beanName)){
            System.out.println("BeanPostProcessor - postProcessAfterInitialization");
/*            Sample sample = (Sample) bean;
            sample.test3();*/
        }
        return bean;
    }
}