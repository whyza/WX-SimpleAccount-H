package com.simpleaccount.expction;

import lombok.Data;

/**
 * @Description: 自定义异常
 * @Author: Whyza
 * @CreateDate: 2019/3/22 10:52
 * @Version: 1.0
 */
@Data
public class CommonException extends  RuntimeException{
    public CommonException(int code, String message) {
        this.code = code;
        this.message = message;
    }
    private int code;
    private String message;
}
