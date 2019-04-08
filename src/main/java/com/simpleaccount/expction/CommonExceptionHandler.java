package com.simpleaccount.expction;

import com.simpleaccount.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/3/22 11:14
 * @Version: 1.0
 */
@RestControllerAdvice
public class CommonExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(HttpServletRequest req,Exception ex) {
        Map map = new HashMap();
        map.put("code", 500);
        map.put("message", ex.getMessage());
        map.put("url", req.getRequestURL());
        map.put("params", req.getParameterMap());
        logger.error("发生未处理的异常={}",ex.getMessage(),ex);
        return map;
    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return
     */
    @ExceptionHandler(value = CommonException.class)
    public Map myErrorHandler(HttpServletRequest req, CommonException ex) {
        Map map = new HashMap();
        map.put("code", ex.getCode());
        map.put("message", ex.getMessage());
        map.put("url", req.getRequestURL());
        map.put("params", req.getParameterMap());
        return map;
    }
}