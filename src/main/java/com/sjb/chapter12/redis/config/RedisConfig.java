package com.sjb.chapter12.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

/**
 * Created by simjunbo on 2018-07-16.
 */
@Configuration
public class RedisConfig {

    // 기본 설정
    @Bean
    public RedisConnectionFactory redisCF() {
        return new JedisConnectionFactory();
    }

    // 다른 호스트
    @Bean
    public RedisConnectionFactory redisCF2() {
        JedisConnectionFactory cf = new JedisConnectionFactory();
        cf.setHostName("redis-server");
        cf.setPort(7379);
        return cf;
    }

    // 인증
    @Bean
    public RedisConnectionFactory redisCF3() {
        JedisConnectionFactory cf = new JedisConnectionFactory();
        cf.setHostName("redis-server");
        cf.setPort(7379);
        cf.setPassword("foobared");
        return cf;
    }

    // Lettuce
    @Bean
    public RedisConnectionFactory redisCF4() {
        LettuceConnectionFactory cf = new LettuceConnectionFactory();
        cf.setHostName("redis-server");
        cf.setPort(7379);
        cf.setPassword("foobared");
        return cf;
    }
}
