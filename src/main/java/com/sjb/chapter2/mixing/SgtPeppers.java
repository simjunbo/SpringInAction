package com.sjb.chapter2.mixing;

import org.springframework.stereotype.Component;

/**
 * Created by simjunbo on 2018-05-29.
 */
@Component("lonelyHeartsClub")
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
