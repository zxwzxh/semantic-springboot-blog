package com.zxw.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author zxw
 * @create 2020-12-23 7:59
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix="spring.datasource.druid")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }
}
