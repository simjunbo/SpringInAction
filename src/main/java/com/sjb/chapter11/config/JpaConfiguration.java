package com.sjb.chapter11.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by simjunbo on 2018-07-05.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.sjb.chapter11")
public class JpaConfiguration {

}
