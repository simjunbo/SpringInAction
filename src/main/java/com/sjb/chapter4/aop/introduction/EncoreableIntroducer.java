package com.sjb.chapter4.aop.introduction;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created by simjunbo on 2018-06-07.
 */
@Aspect
@Component
public class EncoreableIntroducer {
    @DeclareParents(value = "com.sjb.chapter4.aop.introduction.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
