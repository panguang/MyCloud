package com.fuse.Swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerInit {
	@Bean
	public Docket createRestApi() {
		return (new Docket(DocumentationType.SWAGGER_2)).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.fuse")).paths(PathSelectors.any()).build();
	}



	private ApiInfo apiInfo() { return (new ApiInfoBuilder())
        .title("测试电费接口")
       .description("测试查询/缴费接口")
         .contact(new Contact("pg", "", ""))
        .version("1.0")
       .build(); }
}
