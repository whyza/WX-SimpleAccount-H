package com.simpleaccount.controller;

import com.simpleaccount.util.resultutil.ResultUtil;
import com.simpleaccount.util.logfileutil.LogFileUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/3/8 14:25
 * @Version: 1.0
 */
@Controller
public class LogController {
    @ApiOperation(value = "获取日志文件名", notes = "获取日志文件名note")
    @GetMapping("queryLogFileName")
    @ResponseBody
    public ResultUtil queryLogFileName(){
        LogFileUtil.readLogFile("log/logback-debug-2019-03-08.log");
//        return ResultUtil.success(LogFileUtil.getAllFile("log",false));
        return new ResultUtil("请求成功",LogFileUtil.getAllFile("log",false));
    }

    @ApiOperation(value = "读取日志内容", notes = "读取日志内容note")
    @GetMapping("queryLogInfo")
    @ResponseBody
    public ResultUtil queryLogInfo(){
        return new ResultUtil("请求成功",LogFileUtil.readLogFile("log/logback-debug-2019-03-08.log"));
    }
}
