package com.sjb.chapter4.aop.introduction;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by simjunbo on 2018-06-07.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ConcertConfig {
}
