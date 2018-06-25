package com.sjb.chapter7.servlet;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by simjunbo on 2018-06-21.
 */
/*
public class MyServletInitializer implements WebApplicationInitializer {
    // 서블릿 등록
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
        myServlet.addMapping("/custom*/
/**");
        myServlet.setMultipartConfig(
                new MultipartConfigElement("/tmp/spitter/uploads"));
    }
}
*/
