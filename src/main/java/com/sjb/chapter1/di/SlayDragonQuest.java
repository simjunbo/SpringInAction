package com.sjb.chapter1.di;

import java.io.PrintStream;

/**
 * Created by simjunbo on 2018-05-28.
 */
public class SlayDragonQuest implements Quest {
    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void embark() {
        stream.println("Embarking on quesrt to slay the dragon!");
    }
}
