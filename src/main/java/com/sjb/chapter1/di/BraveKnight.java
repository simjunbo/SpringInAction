package com.sjb.chapter1.di;

/**
 * Created by simjunbo on 2018-05-28.
 */
public class BraveKnight implements Knight {
    private Quest quest;

    public BraveKnight(Quest quest) { // 주입
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
