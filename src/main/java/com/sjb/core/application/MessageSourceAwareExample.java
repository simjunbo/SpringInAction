package com.sjb.core.application;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

/**
 * Created by simjunbo on 2018-08-13.
 */
public class MessageSourceAwareExample implements MessageSourceAware {
    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("MessageSourceAware");
    }
}
