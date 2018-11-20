package com.springboot.common.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * @author keith
 * @date 2018-10-14
 */
@Configuration
public class DataSourceConfig {

    /**
     * application.properteis中对应属性的前缀
     * @return
     */
    @Bean(name = "Test")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource dataSourceTest() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "BusinessCard")
    @ConfigurationProperties(prefix = "spring.datasource.businesscard")
    public DataSource dataSourceBusinessCard() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     * @return
     */
    @Bean(name = "dynamicDS")
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(dataSourceTest());

        // 配置多数据源
        Map<Object,Object> dsMap=new HashMap<>(5);
        dsMap.put("test", dataSourceTest());
        dsMap.put("businessCard", dataSourceBusinessCard());

        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }
}
