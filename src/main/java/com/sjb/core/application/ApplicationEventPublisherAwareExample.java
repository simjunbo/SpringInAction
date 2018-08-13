package com.sjb.core.application;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * Created by simjunbo on 2018-08-13.
 */
public class ApplicationEventPublisherAwareExample implements ApplicationEventPublisherAware {
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("ApplicationEventPublisherAware");
    }
}
