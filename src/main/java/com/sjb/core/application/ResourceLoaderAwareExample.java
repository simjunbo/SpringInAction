package com.sjb.core.application;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

/**
 * Created by simjunbo on 2018-08-13.
 */
public class ResourceLoaderAwareExample implements ResourceLoaderAware {
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("ResourceLoaderAware");
    }
}
