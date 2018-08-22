package com.sjb.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by simjunbo on 2018-08-23.
 */
public class ClassPathXmlApplicationContextMain {
	// applicationContext는 항상 preloading 할까? 구현체에 따라서 달라질 수도 있다.
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring-bean-test.xml" }, false);
		context.refresh();
		Entitlement ent = (Entitlement) context.getBean("entitlement");
	}
}
