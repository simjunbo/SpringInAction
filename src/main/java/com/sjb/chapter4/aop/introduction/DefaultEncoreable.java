package com.sjb.chapter4.aop.introduction;

import org.aspectj.lang.annotation.Aspect;

/**
 * Created by simjunbo on 2018-06-07.
 */
@Aspect
public class DefaultEncoreable implements Encoreable {
    public void performEncore() {
        System.out.println("DefaultEncoreable");
    }
}
