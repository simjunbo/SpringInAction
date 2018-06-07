package com.sjb.chapter4.aop.parameter.javaconfig;

import java.util.List;

/**
 * Created by simjunbo on 2018-05-29.
 */
public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;
    private List<String> tracks;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for (String track : tracks) {
            System.out.println("-Track: " + track);
        }
    }

    @Override
    public void playTrack(int trackNumber) {
        System.out.println("-Track " + tracks.get(trackNumber));
    }
}
