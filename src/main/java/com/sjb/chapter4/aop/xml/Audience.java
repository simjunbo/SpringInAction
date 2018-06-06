package com.sjb.chapter4.aop.xml;

import org.aspectj.lang.annotation.*;

/**
 * Created by simjunbo on 2018-06-06.
 */
@Aspect
public class Audience {

    @Pointcut("execution(** com.sjb.chapter4.aop.xml.Performance.perform(..))") // 명명된 포인트커트 정의
    public void performance() { // 실제로는 비어 있다.
    }

    // 공연 이전
    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    // 공연 이전
    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    // 공연 후
    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CALP CALP!!!");
    }

    // 공연 실패 후
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
