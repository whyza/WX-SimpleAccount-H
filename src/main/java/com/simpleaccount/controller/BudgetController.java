package com.simpleaccount.controller;

import com.simpleaccount.entry.Budget;
import com.simpleaccount.service.BudgetService;
import com.simpleaccount.util.resultutil.ResultUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/5/8 20:08
 * @Version: 1.0
 */
@RestController
public class BudgetController {
    @Resource
    BudgetService budgetService;
    @RequestMapping(value = "queryUserBudget",method = {RequestMethod.GET,RequestMethod.POST})
    public ResultUtil<Number> queryUserBudget(Integer accountClassifyId , Integer userId){
        ResultUtil<Number> resultUtil;
        Double userBudget  = budgetService.queryUserBudget(accountClassifyId,userId);
        if(userBudget != null){
            resultUtil  =new ResultUtil<>("200",userBudget);
        }else{
            resultUtil  =new ResultUtil<>("200",0);
        }
        return resultUtil;
    }
    @RequestMapping(value = "setUserBudget",method = {RequestMethod.GET,RequestMethod.POST})
    public ResultUtil<Boolean> setUserBudget(@RequestBody Budget budget){
        return new ResultUtil<>("",budgetService.setUserBudget(budget));
    }

    @RequestMapping(value = "updateUserBudget",method = {RequestMethod.GET,RequestMethod.POST})
    public ResultUtil<Boolean> updateUserBudget(@RequestBody Budget budget){
        return new ResultUtil<>("",budgetService.updateUserBudget(budget));
    }

    @RequestMapping(value = "selectSumForMonth",method = {RequestMethod.GET,RequestMethod.POST})
    public ResultUtil<Double> selectSumForMonth(Integer userId){
        return new ResultUtil<>("",budgetService.selectSumForMonth(userId));
    }
}
