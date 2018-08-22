package com.sjb.core.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by simjunbo on 2018-08-23.
 */
public class BeanFactoryMain {
	public static void main(String[] args) {
		Resource res = new ClassPathResource("spring-bean-test.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		Entitlement ent = (Entitlement)factory.getBean("entitlement");
		System.out.println(ent.getName());
	}
}
