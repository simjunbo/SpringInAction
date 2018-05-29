package com.sjb.chapter2.soundsystem2;

import com.sjb.chapter2.soundsystem.CompactDisc;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by simjunbo on 2018-05-29.
 */
@Named
public class CDPlayer {
    private CompactDisc cd;

    @Inject
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

}
