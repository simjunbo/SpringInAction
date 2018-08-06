package com.sjb.chapter17.amqp.alerts;

import com.sjb.chapter17.jms.domain.Spittle;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Service;

/**
 * Created by simjunbo on 2018-08-03.
 */
public class AlertServiceImpl implements AlertService {
    private RabbitTemplate rabbit;

    @Autowired
    public AlertServiceImpl(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

    @Override
    public void sendSpittleAlert(Spittle spittle) {
        rabbit.convertAndSend(spittle);
    }

    @Override
    public Spittle receiveSpittleAlert() {
        return (Spittle) rabbit.receiveAndConvert("spittle.alert.queue");
    }
}
