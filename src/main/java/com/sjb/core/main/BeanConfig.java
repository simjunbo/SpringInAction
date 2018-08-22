package com.sjb.core.main;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.inject.Named;

/**
 * Created by simjunbo on 2018-08-21.
 */
@Configuration
public class BeanConfig {
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Bean
    public Entitlement entitlement() {
        Entitlement ent = new Entitlement();
        ent.setName("Entitlement");
        ent.setTime(20);
        return ent;
    }
}

