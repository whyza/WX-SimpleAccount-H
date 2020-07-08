package com.simpleaccount.controller;

import com.simpleaccount.entry.Budget;
import com.simpleaccount.service.BudgetService;
import com.simpleaccount.util.resultutil.ResultUtil;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/5/8 20:08
 * @Version: 1.0
 */
@RestController
public class BudgetController {
    @Autowired
    BudgetService budgetService;
    @RequestMapping("queryUserBudget")
    public ResultUtil queryUserBudget(Integer accountClassifyId , Integer userId){
        ResultUtil resultUtil = null;
        Double userBudget  = budgetService.queryUserBudget(accountClassifyId,userId);
        if(userBudget != null){
            resultUtil  =new ResultUtil("200",userBudget);
        }else{
            resultUtil  =new ResultUtil("200",0);
        }
        return resultUtil;
    }
    @RequestMapping("setUserBudget")
    public ResultUtil setUserBudget(@RequestBody Budget budget){
        return new ResultUtil("",budgetService.setUserBudget(budget));
    }

    @RequestMapping("updateUserBudget")
    public ResultUtil updateUserBudget(@RequestBody Budget budget){
        return new ResultUtil("",budgetService.updateUserBudget(budget));
    }

    @RequestMapping("selectSumForMonth")
    public ResultUtil selectSumForMonth(Integer userId){
        return new ResultUtil("",budgetService.selectSumForMonth(userId));
    }
}
