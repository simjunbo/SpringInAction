package com.sjb.chapter2.soundsystem3;

import com.sjb.chapter2.soundsystem.CDPlayer;
import com.sjb.chapter2.soundsystem.CompactDisc;
import com.sjb.chapter2.soundsystem.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by simjunbo on 2018-05-29.
 */
@Configuration
public class JavaConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    // cdPlayer와 anotherCDPlayer는 동일한 객체를 갖는다.
    @Bean
    public CDPlayer cdPlayer() {
        return new CDPlayer(sgtPeppers());
    }

    @Bean
    public CDPlayer anotherCDPlayer() {
        return new CDPlayer(sgtPeppers());
    }

    // CompactDisc의 @Bean을 명시적으로 참조하지 않고서도 생성자에 주입할 수 있다.
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }

    // 생성자가 아닌 세터 메소드를 통해서 주입할 수 있다.
    @Bean
    public CDPlayer cdPlayer2(CompactDisc compactDisc) {
        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.setCompactDisc(compactDisc);
        return cdPlayer;
    }
}
