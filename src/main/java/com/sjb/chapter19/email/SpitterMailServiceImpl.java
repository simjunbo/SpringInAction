package com.sjb.chapter19.email;


import com.sjb.chapter19.domain.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by simjunbo on 2018-08-12.
 */
@Component
public class SpitterMailServiceImpl implements SpitterMailService {

    private JavaMailSender mailSender;

    @Autowired
    public SpitterMailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendSimpleSpittleEmail(String to, Spittle spittle) {
        SimpleMailMessage message = new SimpleMailMessage();
        String spitterName = spittle.getSpitter().getFullName();
        message.setFrom("noreply@spitter.com");
        message.setTo(to);
        message.setSubject("New spittle from " + spitterName);
        message.setText(spitterName + " says: " + spittle.getText());
        mailSender.send(message);
    }

    @Override
    public void sendSpittleEmailWithAttachment(String to, Spittle spittle) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        String spitterName = spittle.getSpitter().getFullName();
        helper.setFrom("noreply@spitter.com");
        helper.setTo(to);
        helper.setSubject("New spittle from " + spitterName);
        helper.setText(spitterName + " says: " + spittle.getText());
        ClassPathResource couponImage = new ClassPathResource("/collateral/coupon.png");
        helper.addAttachment("Coupon.png", couponImage);
        mailSender.send(message);
    }
}

