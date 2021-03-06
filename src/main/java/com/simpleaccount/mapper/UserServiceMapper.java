package com.simpleaccount.mapper;

import com.simpleaccount.entry.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/3/8 10:14
 * @Version: 1.0
 */
@Mapper
public interface UserServiceMapper {
    /**
     * 查询
     * @return
     */
    List<UserInfo> queryUserInfo();

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

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    UserInfo queryUserInfoByName(@Param(value = "userName") String userName);

    /**
     * 根据opendId判断是否已经存在用户
     * @param openId
     * @return
     */
    UserInfo isExitUserByOpenId(String openId);
}
