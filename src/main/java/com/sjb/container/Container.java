package com.sjb.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by simjunbo on 2018-05-28.
 */
public class Container {
    public static void main(String[] args) {
        // FileSystemXmlApplicationContext, ClassPathXmlApplicationContext 차이점은 경로
        // FileSystemXmlApplicationContext
        ApplicationContext context = new FileSystemXmlApplicationContext("c:/knight.xml");

        // ClassPathXmlApplicationContext
        ApplicationContext context2 = new ClassPathXmlApplicationContext("knight.xml");

        ApplicationContext context3 = new AnnotationConfigApplicationContext(
                com.sjb.chapter1.di.KnightConfig.class
        );
    }
}
