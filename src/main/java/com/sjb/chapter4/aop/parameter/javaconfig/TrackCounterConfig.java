package com.sjb.chapter4.aop.parameter.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simjunbo on 2018-06-07.
 */

@Configuration
@EnableAspectJAutoProxy // AspectJ 오토 프록싱 활성화
public class TrackCounterConfig {

    @Bean
    public CompactDisc blankDisc() { // CompactDisc 빈
        BlankDisc cd = new BlankDisc();
        cd.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
        cd.setArtist("The Beatles");

        List<String> tracks = new ArrayList<String>();
        tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
        tracks.add("With a Little Help from My Friends");
        tracks.add("Lucy in the Sky with Diamonds");
        tracks.add("Getting Better");
        tracks.add("Fixing a Hole");
        tracks.add("Fixing a Hole2");
        tracks.add("Fixing a Hole3");
        tracks.add("Fixing a Hole4");
        cd.setTracks(tracks);
        return cd;
    }


    @Bean
    public TrackCounter trackCounter() { // TrackCounter 빈
        return new TrackCounter();
    }
}
