package com.sjb.core.one;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by simjunbo on 2018-08-13.
 */
public class BeanPostProcessorSample implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcessor - postProcessBeforeInitialization : " + o + " s : " + s);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcessor - postProcessAfterInitialization : " + o + " s : " + s);
        return o;
    }
}
