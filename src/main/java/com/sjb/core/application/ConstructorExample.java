package com.sjb.core.application;

/**
 * Created by simjunbo on 2018-08-13.
 */
public class ConstructorExample {
    public ConstructorExample(String name) {
        System.out.println("ConstructorExample : " + name);
    }

    public void setName(String name) {
        System.out.println("ConstructorExample - setter : " + name);
    }
}
