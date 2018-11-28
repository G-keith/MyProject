package com.springboot.common.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author keith
 * @version 1.0
 * @date 2018/11/28 9:37
 */
@Configuration
@MapperScan(basePackages = "com.springboot.modules.project.businesscardmapper", sqlSessionTemplateRef  = "businesscardSqlSessionTemplate")
public class BusinesscardDataSourceConfig {
    @Bean(name = "businesscardDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.businesscard")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "businesscardSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("businesscardDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/businessCard/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "businesscardTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("businesscardDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "businesscardSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("businesscardSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
