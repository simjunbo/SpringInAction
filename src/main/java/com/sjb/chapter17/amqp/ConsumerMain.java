package com.sjb.chapter17.amqp;

/**
 * Created by simjunbo on 2018-08-07.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring/amqp/amqp-consumer.xml");
    }

}