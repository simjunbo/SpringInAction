package com.sjb.chapter4.aop.around;

import org.springframework.stereotype.Component;

/**
 * Created by simjunbo on 2018-06-06.
 */
@Component
public class Musical implements Performance {
    @Override
    public void perform() {
        System.out.println("공연중");
    }
}
