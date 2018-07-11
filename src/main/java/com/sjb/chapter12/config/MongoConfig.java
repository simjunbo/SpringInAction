package com.sjb.chapter12.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

/**
 * Created by simjunbo on 2018-07-11.
 */

// 방식 2
@Configuration
@EnableMongoRepositories(basePackages = "com.sjb.chapter12")    // MongoDB 저장소 활성화
public class MongoConfig extends AbstractMongoConfiguration {
    @Autowired
    private Environment env;

    @Override
    public Mongo mongo() throws Exception {
        MongoCredential credential =
                MongoCredential.createMongoCRCredential(
                        env.getProperty("mongo.username"),
                        "OrdersDB",
                        env.getProperty("mongo.password").toCharArray());

        return new MongoClient(
                new ServerAddress("localhost", 37017),
                Arrays.asList(credential));
    }

    @Override
    protected String getDatabaseName() {
        return "OrdersDB";
    }
}

/*
// 방식 1
@Configuration
@EnableMongoRepositories(basePackages = "com.sjb.chapter12")    // MongoDB 저장소 활성화
public class MongoConfig {

    @Bean
    public MongoFactoryBean mongo() {   // MongoClient 빈
        MongoFactoryBean mongo = new MongoFactoryBean();
        mongo.setHost("localhost");
        return mongo;
    }

    @Bean
    public MongoOperations mongoTemplate(Mongo mongo) { // MongoTeamplte 빈
        return new MongoTemplate(mongo, "OrdersDB");
    }
}*/
