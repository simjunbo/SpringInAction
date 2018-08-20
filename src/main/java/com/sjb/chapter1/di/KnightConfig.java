package com.sjb.chapter1.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by simjunbo on 2018-05-28.
 * 자바 기반의 설정으로 applicationContext에 빈으로 등록한것과 동일 하다.
 */
@Configuration
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }
}

