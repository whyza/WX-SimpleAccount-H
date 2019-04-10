package com.simpleaccount.controller;

import com.simpleaccount.entry.UserInfo;
import com.simpleaccount.service.UserService;
import com.simpleaccount.target.UserLoginToken;
import com.simpleaccount.util.resultutil.ResultUtil;
import com.simpleaccount.util.tokenUtil.CreatToken;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @Description: UserController
 * @Author: Whyza
 * @CreateDate: 2019/3/8 10:27
 * @Version: 1.0
 */
@Controller
@EnableAutoConfiguration
public class UserController {
    @Autowired
    RedisTemplate redisTemplate;
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;
    @Autowired
    CreatToken creatToken;

    @ApiOperation(value = "获取用户信息", notes = "获取用户信息note")
    @RequestMapping("queryUser")
    @ResponseBody
    public ResultUtil queryUser() {
        //LogFileUtil.getAllFile("log",false);
        return new ResultUtil("请求成功", userService.queryUserInfo());
    }

    @ApiOperation(value = "用户注册", notes = "用户注册")
    @RequestMapping("userRegister")
    @ResponseBody
    public ResultUtil userRegister(@RequestBody UserInfo userInfo) {
        return new ResultUtil( "注册成功", userService.userRegister(userInfo));
    }

    @ApiOperation(value = "用户登陆", notes = "用户登陆")
    @RequestMapping("userLogin")
    @ResponseBody
    public ResultUtil userLogin(@RequestBody UserInfo userInfo) {
        HashMap<String, Object> map = new HashMap<>();
        String msg = "";
        map.put("status", userService.userLogin(userInfo));
        if (userService.userLogin(userInfo)) {
            msg = "登陆成功";
            map.put("token", creatToken.createToken(userInfo));
        } else {
            msg = "用户名或密码错误";
        }
        return new ResultUtil(msg,map);
    }

    @ApiOperation(value = "根据用户名查询用户信息", notes = "根据用户名查询用户信息")
    @RequestMapping("queryUserInfoByName")
    @ResponseBody
    @UserLoginToken
    public ResultUtil queryUserInfoByName(String userName) {
        return new ResultUtil("请求成功", userService.queryUserInfoByName(userName));
    }
}
