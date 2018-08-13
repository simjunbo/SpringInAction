package com.sjb.core.application;

import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * Created by simjunbo on 2018-08-13.
 */
public class ServletContextAwareExample implements ServletContextAware {
    @Override
    public void setServletContext(ServletContext servletContext) {
        System.out.println("ServletContextAware");
    }
}
