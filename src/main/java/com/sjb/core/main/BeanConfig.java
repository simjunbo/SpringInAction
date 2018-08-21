package com.sjb.core.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by simjunbo on 2018-08-21.
 */
@Configuration
public class BeanConfig {
    @Bean(name = "entitlement")
    public Entitlement entitlement() {
        Entitlement ent = new Entitlement();
        ent.setName("Entitlement");
        ent.setTime(20);
        return ent;
    }
}

class Entitlement {
    private String name;
    private int time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}