package com.simpleaccount.service.impl;

import com.simpleaccount.entry.UserInfo;
import com.simpleaccount.expction.CommonException;
import com.simpleaccount.mapper.UserServiceMapper;
import com.simpleaccount.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Description: UserServiceImpl
 * @Author: Whyza
 * @CreateDate: 2019/3/8 10:16
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserServiceMapper userServiceMapper;

    @Override
    public List<UserInfo> queryUserInfo() {
        return userServiceMapper.queryUserInfo();
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    @Override
    public UserInfo queryUserInfoByName(String username) {
        UserInfo userInfo  = userServiceMapper.queryUserInfoByName(username);
        if (userInfo == null) {
            throw new CommonException(400,"用户不存在，请重新登录");
        }
        return userInfo;
    }

    /**
     * 用户登陆
     *
     * @param userInfo
     * @return
     */
    @Override
    public boolean userLogin(UserInfo userInfo) {
        UserInfo users = userServiceMapper.queryUserInfoByName(userInfo.getUsername());
        if (users != null) {
            String userPwd = DigestUtils.md5DigestAsHex((userInfo.getUsername() + userInfo.getPassword()).getBytes());
            if ((users.getUsername().equals(userInfo.getUsername()) && users.getPassword().equals(userPwd)) == true) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    /**
     * 用户注册
     *
     * @return
     */
    @Override
    public boolean userRegister(UserInfo userInfo) {
        if (userInfo != null) {
            // 将密码加盐
            userInfo.setPassword(userInfo.getUsername() + userInfo.getPassword());
            // 将密码设置为md5密文密码形式
            userInfo.setPassword(DigestUtils.md5DigestAsHex(userInfo.getPassword().getBytes()));
            userInfo.setRegistertime(new Timestamp(System.currentTimeMillis()));
            // 添加到数据库
            return userServiceMapper.userRegister(userInfo);
        } else {
            return false;
        }
    }
}
