package com.sjb.chapter10;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

/**
 * Created by simjunbo on 2018-07-02.
 */
@Configuration
public class DataSourceConfiguration {

    // 임베디드
    @Profile("development")
    @Bean
    public javax.sql.DataSource embeddedDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:com/sjb/chapter10/create-db.sql")
                .addScript("classpath:com/sjb/chapter10/insert-data.sql")
                .build();
    }

    // DBCP
    @Profile("qa")
    @Bean
    public BasicDataSource data() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:tcp://localhost/~/spitter");
        ds.setUsername("sa");
        ds.setPassword("");
        ds.setInitialSize(5);
        ds.setMaxActive(10);
        return ds;
    }

    // JNDI
    @Profile("production")
    @Bean
    public JndiObjectFactoryBean dataSource() {
        JndiObjectFactoryBean jndiObjectFB = new JndiObjectFactoryBean();
        jndiObjectFB.setJndiName("jdbc/SpitterDS");
        jndiObjectFB.setResourceRef(true);
        jndiObjectFB.setProxyInterface(javax.sql.DataSource.class);
        return jndiObjectFB;
    }


    // JDBC(Spring)
    @Bean
    public javax.sql.DataSource dataSource3() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:tcp://localhost/~/spitter");
        ds.setUsername("sa");
        ds.setPassword("");
        return ds;
    }

}
