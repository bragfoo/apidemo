package com.liuhx.apidemo.config;

import com.liuhx.apidemo.config.properties.RefreshableProperties;
import com.liuhx.apidemo.config.properties.ThirdTestServiceProperties;
import com.liuhx.apidemo.config.properties.ThirdWeatherProperties;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * 应用基础配置
 *
 * @author shiyongbiao
 */
@EnableSwagger2Doc
@EnableAsync
@EnableConfigurationProperties(value = {ThirdTestServiceProperties.class, ThirdWeatherProperties.class, RefreshableProperties.class})
@Configuration
@MapperScan(basePackages = {"com.liuhx.apidemo.dao.mapper"})
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {"com.liuhx.apidemo.dao.repository"}, queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND)
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.setConnectTimeout(Duration.ofSeconds(3)).setReadTimeout(Duration.ofSeconds(30)).build();
    }

}