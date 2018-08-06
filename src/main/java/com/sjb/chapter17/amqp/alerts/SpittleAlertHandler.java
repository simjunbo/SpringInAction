package com.sjb.chapter17.amqp.alerts;

import com.sjb.chapter17.jms.domain.Spittle;

/**
 * Created by simjunbo on 2018-08-03.
 */
public class SpittleAlertHandler {
    public void handleSpittleAlert(Spittle spittle) {
        System.out.println(spittle.getMessage());
    }
}
