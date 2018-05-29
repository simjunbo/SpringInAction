package com.sjb.chapter2.soundsystem;

import org.springframework.stereotype.Component;
import javax.inject.Named;

/**
 * Created by simjunbo on 2018-05-29.
 */
//@Named("lonelyHeartsClub")
@Component("lonelyHeartsClub")
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
