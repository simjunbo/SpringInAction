package com.sjb.chapter3.scope;

import com.sjb.chapter2.soundsystem.CompactDisc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Created by simjunbo on 2018-05-29.
 */
public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;

    /*
    // 플레이스홀더 방식
    public BlankDisc(
            @Value("${disc.title}") String title,
            @Value("${disc.artist}") String artist) {
        this.title = title;
        this.artist = artist;
    }*/

    // SpEL 방식
    public BlankDisc(
            @Value("#{systemProperties['disc.title']}") String title,
            @Value("#{systemProperties['disc.artist']}") String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
