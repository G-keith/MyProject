package com.springboot.common.datasource.mybatisconfig;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author keith
 * @date 2018-10-14
 */
@Configuration
@MapperScan(basePackages = {"com.springboot.modules.project.businesscardmapper"}, sqlSessionFactoryRef = "sqlSessionFactoryBusinessCard")
public class MybatisDbBusinessCardConfig {

    @Autowired
    @Qualifier("BusinessCard")
    private DataSource businessCard;


    @Bean
    public SqlSessionFactory sqlSessionFactoryBusinessCard() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        //使用businessCard数据源, 连接vicmob_businessCard库
        factoryBean.setDataSource(businessCard);
              factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/**/*Mapper.xml"));
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateBusinessCard() throws Exception {
        // 使用上面配置的Factory
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryBusinessCard());
        return template;
    }
}
