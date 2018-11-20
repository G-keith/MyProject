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
@MapperScan(basePackages = {"com.springboot.modules.project.testmapper"}, sqlSessionFactoryRef = "sqlSessionFactoryTest")
public class MybatisDbTestConfig {

    @Autowired
    @Qualifier("Test")
    private DataSource test;


    @Bean
    public SqlSessionFactory sqlSessionFactoryTest() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        //使用test数据源, 连接vicmob_test库
        factoryBean.setDataSource(test);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/**/*Mapper.xml"));
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateTest() throws Exception {
        // 使用上面配置的Factory
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryTest());
        return template;
    }
}
