package com.simpleaccount;

import com.simpleaccount.controller.UserController;
import com.simpleaccount.websocket.LoggerMessage;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

import javax.annotation.PostConstruct;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
