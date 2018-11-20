package com.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author keith
 * @date 2018-07-09
 */
@EnableScheduling
@EnableSwagger2
@EnableAsync
@MapperScan(basePackages = {"com.springboot.modules.project.testmapper","com.springboot.modules.project.businesscardmapper"})
@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class
})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
