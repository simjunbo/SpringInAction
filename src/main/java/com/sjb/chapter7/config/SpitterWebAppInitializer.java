package com.sjb.chapter7.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * Created by simjunbo on 2018-06-14.
 */
/*public class SpitterWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // DispatcherServlet이 매핑되기 위한 하나 혹은 여러개의 패스를 지정한다.
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // 이것은 애플리케이션으로 들어오는 모든 요청을 처리한다.
    }


    @Override
    protected Class<?>[] getServletConfigClasses() { // 이것은 servlet-context
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() { // 이것은 root-context
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement("/tmp/spitter/uploads")
        );
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{
                new MyFilter()
        };
    }
}*/
