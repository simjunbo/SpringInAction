package com.sjb.chapter2.mixing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by simjunbo on 2018-05-29.
 */
@Component
public class CDPlayer implements MediaPlyer {
    private CompactDisc cd;

    public CDPlayer() {

    }

    // 생성자
    @Autowired(required = false)
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    // 프러퍼티 세터
    @Autowired
    public void setCompactDisc(CompactDisc cd) {
        this.cd = cd;
    }

    @Autowired
    public void insertDisc(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
