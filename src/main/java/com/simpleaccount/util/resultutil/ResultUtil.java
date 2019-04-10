package com.simpleaccount.util.resultutil;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/3/8 11:07
 * @Version: 1.0
 */
@Data
public class ResultUtil<T> implements Serializable {
//    /**
//     * 是否成功
//     */
//    private boolean success;

    private String message;
    /**
     * 返回数据
     */
    private T data;
    public ResultUtil() {
    }
    public ResultUtil(String message, T data) {
//        this.success = success;
        this.message = message;
        this.data = data;
    }
}
