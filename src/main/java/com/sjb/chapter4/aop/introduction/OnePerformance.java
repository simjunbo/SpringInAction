package com.sjb.chapter4.aop.introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by simjunbo on 2018-06-07.
 */
@Component
public class OnePerformance implements Performance {
    @Autowired
    public OnePerformance() {
    }

    public void perform() {
        System.out.println("The Band is performing....");
    }
}
