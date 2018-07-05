package com.sjb.chapter11.hibernate;

import com.sjb.chapter11.domain.Spitter;
import com.sjb.chapter11.domain.Spittle;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by simjunbo on 2018-07-05.
 */
public class Hibernate {
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource);
        //sfb.setMappingResources(new String[]{"Spitter.hbm.xml"});
        //sfb.setPackagesToScan(new String[]{"com.habuma.spitter.domain"});
        sfb.setAnnotatedClasses(
                new Class<?>[]{Spitter.class, Spittle.class}
        );
        Properties props = new Properties();
        props.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
        sfb.setHibernateProperties(props);
        return sfb;
    }

    /*
    LocalSessionFactoryBean 로 대체됨
     */
    @Bean
    public AnnotationSessionFactoryBean sessionFactory2(DataSource dataSource) {
        AnnotationSessionFactoryBean sfb = new AnnotationSessionFactoryBean();
        sfb.setDataSource(dataSource);
        sfb.setPackagesToScan(new String[]{"com.sjb.chapter11.jpa"});
        Properties props = new Properties();
        props.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
        sfb.setHibernateProperties(props);
        return sfb;
    }
}
