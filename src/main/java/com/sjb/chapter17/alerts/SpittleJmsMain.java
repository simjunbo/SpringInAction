package com.sjb.chapter17.alerts;

import com.sjb.chapter17.domain.Spittle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by simjunbo on 2018-08-03.
 */
public class SpittleJmsMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/messaging.xml");
        AlertService alertService = context.getBean(AlertService.class);

        Spittle spittle = new Spittle(1L, null, "Hello", new Date());
        alertService.sendSpittleAlert(spittle);
    }
}
