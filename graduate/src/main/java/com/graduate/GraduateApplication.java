package com.graduate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *    * 需要把web项目打成war包部署到外部tomcat运行时需要改变启动方式    
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan("com.graduate.Dao")
public class GraduateApplication /* extends SpringBootServletInitializer */ {

	public static void main(String[] args) {
		SpringApplication.run(GraduateApplication.class, args);
	}


	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder builder) { return
	 * builder.sources(GraduateApplication.class);
	 *
	 * }
	 */

}
