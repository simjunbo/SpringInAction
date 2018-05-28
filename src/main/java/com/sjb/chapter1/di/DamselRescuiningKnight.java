package com.sjb.chapter1.di;

/**
 * Created by simjunbo on 2018-05-28.
 */
public class DamselRescuiningKnight implements Knight {
    private RescueDamselQuest quest;

    public DamselRescuiningKnight() {
        this.quest = new RescueDamselQuest();
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
