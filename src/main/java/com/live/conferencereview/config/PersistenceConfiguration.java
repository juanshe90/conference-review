//package com.live.conferencereview.config;
//
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import javax.sql.DataSource;
//
//@Configuration
//public class PersistenceConfiguration {
//
//    @Bean
//    public DataSource dataSource(){
//        DataSourceBuilder builder = DataSourceBuilder.create();
//        builder.url("jdbc:postgresql://postgres/review_database");
//        builder.password("Welcome");
//        builder.username("postgres");
//        return builder.build();
//    }
//}
