package com.simpleaccount.controller;

import com.alibaba.fastjson.JSONObject;
import com.simpleaccount.configuration.AuthCode2Session;
import com.simpleaccount.entry.UserInfo;
import com.simpleaccount.service.UserService;
import com.simpleaccount.target.UserLoginToken;
import com.simpleaccount.util.httlClient.HttpClientUtil;
import com.simpleaccount.util.resultutil.ResultUtil;
import com.simpleaccount.util.tokenUtil.CreatToken;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        return new ResultUtil("注册成功", userService.userRegister(userInfo));
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
        return new ResultUtil(msg, map);
    }

    @ApiOperation(value = "微信用户授权登陆", notes = "微信用户授权登陆")
    @RequestMapping("userLoginByWeChat")
    @ResponseBody
    public ResultUtil userLoginByWeChat(@RequestBody UserInfo userInfo) {
        // 配置请求参数
        Map<String, String> param = new HashMap<>();
        param.put("appid", AuthCode2Session.WX_LOGIN_APPID);
        param.put("secret", AuthCode2Session.WX_LOGIN_SECRET);
        param.put("js_code", userInfo.getCode());
        param.put("grant_type", AuthCode2Session.WX_LOGIN_GRANT_TYPE);
        // 发送请求
        String wxResult = HttpClientUtil.doGet(AuthCode2Session.WX_LOGIN_URL, param);
        JSONObject jsonObject = JSONObject.parseObject(wxResult);
        // 获取参数返回的
        String session_key = jsonObject.get("session_key").toString();
        String open_id = jsonObject.get("openid").toString();
        // 根据返回的user实体类，判断用户是否是新用户，不是的话，更新最新登录时间，是的话，将用户信息存到数据库
        UserInfo user = userService.isExitUserByOpenId(open_id);
        if (user == null) {
            // 添加到数据库
            userInfo.setOpenId(open_id);
            userService.userRegister(userInfo);
        }
        // 封装返回小程序
        Map<String, String> result = new HashMap<>();
        result.put("session_key", session_key);
        result.put("open_id", open_id);
        result.put("token", creatToken.createToken(userInfo));
        return new ResultUtil("", result);
    }


    @ApiOperation(value = "根据用户名查询用户信息", notes = "根据用户名查询用户信息")
    @RequestMapping("queryUserInfoByName")
    @ResponseBody
    @UserLoginToken
    public ResultUtil queryUserInfoByName(String userName) {
        return new ResultUtil("请求成功", userService.queryUserInfoByName(userName));
    }
    @ApiOperation(value = "根据用户openId查询用户信息", notes = "根据用户openId查询用户信息")
    @RequestMapping("queryUserInfoByOpenId")
    @ResponseBody
    public ResultUtil queryUserInfoByOpenId(String openId) {
        return new ResultUtil("请求成功", userService.isExitUserByOpenId(openId));
    }


}
