package com.sjb.chapter1.aop;

import com.sjb.chapter1.di.Knight;
import com.sjb.chapter1.di.Quest;

/**
 * Created by simjunbo on 2018-05-28.
 * 직접적으로 호출해야 된다... 음유시인이 기사에 종속되어 있다.
 * 기사가 음유시인을 원하지 않는다면?
 */
public class BraveKnight implements Knight {
    private Quest quest;
    private Minstrel minstrel;

    public BraveKnight(Quest quest, Minstrel minstrel) { // 주입
        this.quest = quest;
        this.minstrel = minstrel;
    }

    public void embarkOnQuest() {
        minstrel.singBeforeQuest(); // 기사가 자신의 음유시인을 관리해야 할까?
        quest.embark();
        minstrel.singAfterQuest();
    }
}
