package com.sjb.chapter17;

/**
 * Created by simjunbo on 2018-08-03.
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsOperations;

public class JMSMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/messaging.xml");
        JmsOperations jms = context.getBean(JmsOperations.class);
        for (int i = 0; i < 10; i++) {
            jms.convertAndSend("hello.queue", "Hello");
        }
        String receive = (String) jms.receiveAndConvert("hello.queue");
        System.out.println(receive);
        context.close();
    }

}