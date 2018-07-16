package com.sjb.chapter12.neo4j.config;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

/**
 * Created by simjunbo on 2018-07-16.
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "com.sjb.chapter12") // 자동 저장소 활성화
public class Neo4jConfig extends Neo4jConfiguration {

    public Neo4jConfig() {  // 모델 베이스 패키지 세팅
        setBasePackage("orders");
    }

    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory()
                .newEmbeddedDatabase("/tmp/graphdb"); // 임베디드 데이터베이스 패키지 설정
    }


}
