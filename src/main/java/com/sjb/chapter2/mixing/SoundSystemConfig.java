package com.sjb.chapter2.mixing;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by simjunbo on 2018-05-30.
 */
@Configuration
@Import(CDPlayerConfig.class)
@ImportResource("classpath:spring-test/chapter2/cd-config.xml")
public class SoundSystemConfig {
}
