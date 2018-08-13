package com.sjb.core.application;

import javax.annotation.PreDestroy;

/**
 * Created by simjunbo on 2018-08-13.
 */
public class PreDestroyExample {
    @PreDestroy
    public void cleanUp() throws Exception {
        System.out.println("@PreDestroy");
    }
}