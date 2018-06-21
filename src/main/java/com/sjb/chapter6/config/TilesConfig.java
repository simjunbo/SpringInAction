package com.sjb.chapter6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

/**
 * Created by simjunbo on 2018-06-21.
 */
@Configuration
public class TilesConfig {
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/layout/tiles.xml");
        tilesConfigurer.setCheckRefresh(true);

        return tilesConfigurer;
    }
}