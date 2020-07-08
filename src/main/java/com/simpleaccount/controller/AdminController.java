package com.simpleaccount.controller;

import com.github.pagehelper.PageInfo;
import com.simpleaccount.entry.BillClassfyTree;
import com.simpleaccount.entry.Billclassify;
import com.simpleaccount.entry.UserInfo;
import com.simpleaccount.service.BillClassfyService;
import com.simpleaccount.service.UserService;
import com.simpleaccount.util.resultutil.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
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


    @ApiOperation(value = "更新账单分类", notes = "更新账单分类")
    @PostMapping("updateBillClassify")
    @ResponseBody
    public ResultUtil updateBillClassify(@RequestBody Billclassify billclassify) {
        return BillTypeService.updateBillClassify(billclassify);
    }
}
