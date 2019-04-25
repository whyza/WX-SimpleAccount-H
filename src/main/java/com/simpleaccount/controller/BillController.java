package com.simpleaccount.controller;

import com.simpleaccount.entry.Bill;
import com.simpleaccount.service.BillService;
import com.simpleaccount.util.resultutil.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: BillController
 * @Author: Whyza
 * @CreateDate: 2019/4/25 10:03
 * @Version: 1.0
 */
@RestController
public class BillController {
    @Autowired
    BillService billService;

    @ApiOperation(value = "新增账单", notes = "新增账单")
    @RequestMapping("addBill")
    @ResponseBody
    public ResultUtil addBill(@RequestBody Bill bill) {
        if (bill.getAccountClassifyId() == null) {
            return new ResultUtil("账户名称不能为空",false);
        } else if (bill.getDate() == null) {
            return new ResultUtil("请选择日期",false);
        } else if (bill.getClassify() == null) {
            return new ResultUtil("请选择分类",false);
        } else {
            return billService.addBill(bill);
        }
    }
}
