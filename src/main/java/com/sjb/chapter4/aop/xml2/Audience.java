package com.sjb.chapter4.aop.xml2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by simjunbo on 2018-06-06.
 */
public class Audience {
    // 공연 이전
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    // 공연 이전
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    // 공연 후
    public void applause() {
        System.out.println("CLAP CALP CALP!!!");
    }

    // 공연 실패 후
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("Silencing cell phones"); // 공연 전
            System.out.println("Taking seats");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
    }
}
