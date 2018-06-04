package com.sjb.chapter3.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by simjunbo on 2018-05-30.
 */
@Component
public class AutowiredExample {
    private Dessert dessert;

    private String title;
    private String artist;

    @Autowired
    @Cold
    @Cremy
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }
}
