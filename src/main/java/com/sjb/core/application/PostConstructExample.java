package com.sjb.core.application;

import javax.annotation.PostConstruct;

/**
 * Created by simjunbo on 2018-08-13.
 */
public class PostConstructExample {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @PostConstruct
    public void initIt() throws Exception {
        System.out.println("@PostConstruct : " + message);
    }
}