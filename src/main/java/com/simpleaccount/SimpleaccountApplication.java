package com.simpleaccount;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 * @Description: 启动类
 * @param: 
 * @return: 
 * @auther: LS
 * @date: 2019/3/8 19:57
 */
@SpringBootApplication
//开启缓存
@EnableCaching
@MapperScan("com.simpleaccount.mapper")
public class SimpleaccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleaccountApplication.class, args);
    }
}
