package com.simpleaccount;

import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

/**
 *
 * @Description: 启动类
 * @param:
 * @return:
 * @auther: LS
 * @date: 2019/3/8 19:57
 */
@SpringBootApplication()
@EnableCaching
@MapperScan("com.simpleaccount.mapper")
public class SimpleaccountApplication{
    public static void main(String[] args) {
        SpringApplication.run(SimpleaccountApplication.class, args);
    }
}
