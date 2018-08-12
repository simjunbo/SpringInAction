package com.sjb.chapter19.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Created by simjunbo on 2018-08-12.
 */
@Configuration
@ComponentScan("com.sjb.chapter19")
@PropertySource("classpath:mail.properties")
public class MailConfig {

    // JavaMailSendImpl Environment 방식
    @Bean
    public MailSender mailSender(Environment env) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("mailserver.host"));
        mailSender.setPort(Integer.parseInt(env.getProperty("mailserver.port")));
        mailSender.setUsername(env.getProperty("mailserver.username"));
        mailSender.setPassword(env.getProperty("mailserver.password"));
        return mailSender;
    }

    // JNDI 방식
    @Bean
    public JndiObjectFactoryBean mailSession() {
        JndiObjectFactoryBean jndi = new JndiObjectFactoryBean();
        jndi.setJndiName("mail/Session");
        jndi.setProxyInterface(MailSession.class);
        jndi.setResourceRef(true);
        return jndi;
    }

    /*
    // JavaMailSendImpl를 JNDI로 교체
    @Bean
    public MailSender mailSender2(MailSession mailSession) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setSession(mailSession);
        return mailSender;
    }
    */

/*
    @Bean
    public JavaMailSenderImpl mailSender(Environment env) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("mailserver.host"));
        mailSender.setPort(Integer.parseInt(env.getProperty("mailserver.port")));
        mailSender.setUsername(env.getProperty("mailserver.username"));
        mailSender.setPassword(env.getProperty("mailserver.password"));
        return mailSender;
    }*/
}