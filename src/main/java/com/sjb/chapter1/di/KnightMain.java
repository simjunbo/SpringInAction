package com.sjb.chapter1.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by simjunbo on 2018-05-28.
 */
public class KnightMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =            // 스프링 컨텍스트 로드
                new ClassPathXmlApplicationContext(
                        "classpath:spring-test/knights.xml"
                );
        Knight knight = context.getBean(Knight.class);      // 기사 빈 얻기
        knight.embarkOnQuest();                             // 기사 사용
        context.close();
    }
}
