package com.sjb.chapter17.alerts;

import com.sjb.chapter17.data.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Service;

/**
 * Created by simjunbo on 2018-08-03.
 */
@Service
public class AlertServiceImpl implements AlertService {
    private JmsOperations jmsOperations;

    @Autowired
    public AlertServiceImpl(JmsOperations jmsOperations) {
        this.jmsOperations = jmsOperations;
    }

/*    @Override
    public void sendSpittleAlert(Spittle spittle) {
        jmsOperations.send(
                new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createObjectMessage(spittle);
                    }
                }
        );
    }*/

    @Override
    public void sendSpittleAlert(Spittle spittle) {
        jmsOperations.convertAndSend(spittle);
    }

    /*
        public Spittle receiveSpittleAlert() {
            try {
                ObjectMessage receivedMessage =
                        (ObjectMessage) jmsOperations.receive();    // 메시지 수신
                return (Spittle) receivedMessage.getObject();       // 객체 얻기
            } catch (JMSException jmsExcetion) {
                throw JmsUtils.convertJmsAccessException(jmsExcetion); // 변환된 예외 던지기 (비검사형 예외)
            }
        }
    */
    @Override
    public Spittle receiveSpittleAlert() {
        return (Spittle) jmsOperations.receiveAndConvert();
    }
}
