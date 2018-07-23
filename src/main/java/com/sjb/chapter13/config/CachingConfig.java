package com.sjb.chapter13.config;

import net.sf.ehcache.CacheManager;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public EhCacheCacheManager cacheManager(CacheManager cm) {  // EhCacheCacheManager 설정
        return new EhCacheCacheManager(cm);
    }

    @Bean
    public EhCacheManagerFactoryBean ehcache() { // EhCacheManagerFactoryBean
        EhCacheManagerFactoryBean ehCacheFactoryBean =
                new EhCacheManagerFactoryBean();
        ehCacheFactoryBean.setConfigLocation(
                new ClassPathResource("com/sjb/chapter13/cache/ehcache.xml")
        );
        return ehCacheFactoryBean;
    }
}
