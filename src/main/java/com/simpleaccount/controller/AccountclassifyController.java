package com.simpleaccount.controller;

import com.simpleaccount.entry.Accountclassify;
import com.simpleaccount.service.AccountclassifyService;
import com.simpleaccount.util.resultutil.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/25 7:58
 * @Version: 1.0
 */
@RestController
public class AccountclassifyController {
    @Autowired
    AccountclassifyService accountclassifyService;
    @ApiOperation(value = "根据fAccountclassifyId查询账户信息", notes = "根据fAccountclassifyId查询账户信息")
    @RequestMapping("queryAccClassifyInfoByfId")
    @ResponseBody
    public ResultUtil queryAccClassifyInfoByfId(Integer fAccountclassifyId,Integer userId) {
        return new ResultUtil("请求成功", accountclassifyService.queryAllAccClassifyInfoByfId(fAccountclassifyId,userId));
    }
}