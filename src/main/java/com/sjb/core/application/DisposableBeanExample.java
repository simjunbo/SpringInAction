package com.sjb.core.application;

import org.springframework.beans.factory.DisposableBean;

/**
 * Created by simjunbo on 2018-08-13.
 */
public class DisposableBeanExample implements DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean");
    }
}
