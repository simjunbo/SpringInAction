package com.sjb.chapter3.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by simjunbo on 2018-06-04.
 */

@Configuration
@PropertySource("classpath:applicationProperty.properties")
public class ExpressiveConfig {

    @Autowired
    Environment env;

    @Bean
    public BlankDisc disc() {
        return new BlankDisc(
                env.getProperty("disc.title", "Rattle and Hum"),
                env.getProperty("disc.artist", "U2")
        );
    }

    @Bean
    public BlankDisc disc2() {
        boolean titleExist = env.containsProperty("disc.title");

        return new BlankDisc(
                env.getRequiredProperty("disc.title"),
                env.getRequiredProperty("disc.artist")
        );
    }

    private void envTest() {
        int connectionCount = env.getProperty("db.connection.count", Integer.class, 30);
    }

}
