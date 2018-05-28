package com.sjb.chapter1.aop;

import java.io.PrintStream;

/**
 * Created by simjunbo on 2018-05-28.
 */
public class Minstrel {
    private PrintStream stream;

    public Minstrel(PrintStream stream) {
        this.stream = stream;
    }

    public void singBeforeQuest() { // 원정전에 호출됨
        stream.println("Fa la la, the knight is so brave!");
    }

    public void singAfterQuest() { // 원정후에 호출됨
        stream.println("Tee hee hee, the brave knight " +
                "did embark on a quesrt!");
    }
}
