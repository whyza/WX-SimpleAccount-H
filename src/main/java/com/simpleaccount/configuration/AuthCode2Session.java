package com.simpleaccount.configuration;

/**
 * @Description: AuthCode2Session
 * @Author: Whyza
 * @CreateDate: 2019/4/11 12:56
 * @Version: 1.0
 */
public class AuthCode2Session {
    /**
     * 请求的网址
     */
    public static final String WX_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session";
    /**
     * appid
     */
    public static final String WX_LOGIN_APPID = "wxfd2ebef9dd9999af";
    /**
     * 密匙
     */
    public static final String WX_LOGIN_SECRET = "01a3baf10e773c18951cd73842af747e";
    /**
     * 固定参数
     */
    public static final String WX_LOGIN_GRANT_TYPE = "authorization_code";
}
