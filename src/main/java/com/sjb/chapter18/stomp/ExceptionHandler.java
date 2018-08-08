package com.sjb.chapter18.stomp;

import org.springframework.messaging.handler.annotation.MessageExceptionHandler;

/**
 * Created by simjunbo on 2018-08-07.
 */
public class ExceptionHandler {

    @MessageExceptionHandler
    public void handleException(Throwable t) {

    }
}
