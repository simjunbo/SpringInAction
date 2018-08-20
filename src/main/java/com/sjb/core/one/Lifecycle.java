package com.sjb.core.one;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.context.ServletContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletContext;

/**
 * Created by simjunbo on 2018-08-13.
 */
public class Lifecycle implements ApplicationContextAware, ApplicationEventPublisherAware, MessageSourceAware, ResourceLoaderAware, EnvironmentAware
        , ServletContextAware, BeanClassLoaderAware, BeanFactoryAware, BeanNameAware, DisposableBean,
        InitializingBean {

    public Lifecycle(String name) {
        System.out.println("Lifecycle constructor : " + name);
    }

    public void setName(String name) {
        System.out.println("Lifecycle setter : " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("ApplicationEventPublisherAware");
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("EnvironmentAware");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("MessageSourceAware");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("ResourceLoaderAware");
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        System.out.println("ServletContextAware");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("BeanClassLoaderAware");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware");
    }

    @Override
    public void destroy() {
        System.out.println("DisposableBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean");
    }

    public void initMethod() {
        System.out.println("init-method");
    }

    public void destroyMethod() {
        System.out.println("destroy-method");
    }


    @PostConstruct
    public void initIt() throws Exception {
        System.out.println("@PostConstruct");
    }

    @PreDestroy
    public void cleanUp() throws Exception {
        System.out.println("@PreDestroy");
    }
}
