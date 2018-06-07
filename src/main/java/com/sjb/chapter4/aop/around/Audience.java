package com.sjb.chapter4.aop.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by simjunbo on 2018-06-06.
 */
@Aspect
public class Audience {

    @Pointcut("execution(** com.sjb.chapter4.aop.around.Performance.perform(..))") // 명명된 포인트커트 정의
    public void performance() { // 실제로는 비어 있다.
    }

    // 공연 이전
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("Sliencing cell phones");
            System.out.println("Taking seats");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
    }
}
