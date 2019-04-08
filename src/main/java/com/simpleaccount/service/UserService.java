package com.simpleaccount.service;

import com.simpleaccount.entry.UserInfo;
import com.simpleaccount.util.resultutil.ResultUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/3/8 10:14
 * @Version: 1.0
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    List<UserInfo> queryUserInfo();
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    UserInfo queryUserInfoByName(String username);
    /**
     * 用户登陆
     * @param userInfo
     * @return
     */
    boolean userLogin(UserInfo userInfo);

    /**
     * 用户注册
     * @param userInfo
     * @return
     */
    boolean userRegister(UserInfo userInfo);
}
