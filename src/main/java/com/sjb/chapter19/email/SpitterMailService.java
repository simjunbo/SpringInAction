package com.sjb.chapter19.email;

import com.sjb.chapter19.domain.Spittle;
import org.springframework.messaging.MessagingException;

/**
 * Created by simjunbo on 2018-08-12.
 */
public interface SpitterMailService {
    public abstract void sendSimpleSpittleEmail(String to, Spittle spittle);

    public abstract void sendSpittleEmailWithAttachment(String to, Spittle spittle)
            throws MessagingException, javax.mail.MessagingException;

}
