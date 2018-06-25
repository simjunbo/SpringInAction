package com.sjb.chapter7.filter;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by simjunbo on 2018-06-21.
 */
/*
public class MyServletInitializer implements WebApplicationInitializer {
    // 필터 등록
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        FilterRegistration.Dynamic filter = servletContext.addFilter("myFilter", MyFilter.class);
        filter.addMappingForUrlPatterns(null, false, "/custom*//*");
    }
}
*/
