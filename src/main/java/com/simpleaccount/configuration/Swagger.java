package com.simpleaccount.configuration;

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

/**
 * @Description: 配置 swagger
 * @Author: Whyza
 * @CreateDate: 2019/3/11 9:29
 * @Version: 1.0
 */
@Configuration
@EnableSwagger2
public class Swagger {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.simpleaccount.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo buildApiInfo(){
        return new ApiInfoBuilder()
                .title("记账小帮手  --api")
                .description("api")
                .termsOfServiceUrl("https://iazuresky.com")
                .contact(new Contact(
                        "whyzaa",
                        "https://iazuresky.com",
                        "whyzaa@163.com"))
                .version("1.0")
                .build();
    }

}
