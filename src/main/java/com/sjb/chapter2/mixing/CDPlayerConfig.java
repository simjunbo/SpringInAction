package com.sjb.chapter2.mixing;

import com.sjb.chapter2.soundsystem.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by simjunbo on 2018-05-30.
 */
@Configuration
@Import(CDConfig.class)
public class CDPlayerConfig {

    @Bean
    public CDPlayer cdplayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);

    }
}
