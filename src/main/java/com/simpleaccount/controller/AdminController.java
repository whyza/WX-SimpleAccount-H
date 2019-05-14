package com.simpleaccount.controller;

import com.github.pagehelper.PageInfo;
import com.simpleaccount.entry.BillClassfyTree;
import com.simpleaccount.entry.UserInfo;
import com.simpleaccount.service.BillClassfyService;
import com.simpleaccount.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/5/13 17:08
 * @Version: 1.0
 */
@RestController
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    BillClassfyService BillTypeService;
    //    queryAdminClassify
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息note")
    @RequestMapping("queryUser")
    @ResponseBody
    public PageInfo<UserInfo> queryUser(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                        @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        return userService.queryUserInfo(pageNum, pageSize);
    }


    @ApiOperation(value = "获取分类信息", notes = "获取分类信息")
    @RequestMapping("queryAdminClassify")
    @ResponseBody
    public List<BillClassfyTree> queryAdminClassify(Integer classifyType) {
        return BillTypeService.queryAdminClassify(classifyType);
    }
}
