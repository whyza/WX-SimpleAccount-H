package com.simpleaccount.controller;

import com.simpleaccount.entry.Accountclassify;
import com.simpleaccount.entry.Budget;
import com.simpleaccount.entry.BudgetVo;
import com.simpleaccount.service.AccountclassifyService;
import com.simpleaccount.service.BudgetService;
import com.simpleaccount.util.resultutil.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/25 7:58
 * @Version: 1.0
 */
@Controller
public class AccountclassifyController {
    @Autowired
    AccountclassifyService accountclassifyService;
    @Autowired
    BudgetService budgetService;

    @ApiOperation(value = "根据fAccountclassifyId查询账户信息", notes = "根据fAccountclassifyId查询账户信息")
    @RequestMapping("queryAccClassifyInfoByfId")
    @ResponseBody
    public ResultUtil queryAccClassifyInfoByfId(Integer fAccountclassifyId, Integer userId) {
        return new ResultUtil("请求成功", accountclassifyService.queryAllAccClassifyInfoByfId(fAccountclassifyId, userId));
    }

    @RequestMapping("queryBudget")
    @ResponseBody
    public List<BudgetVo> queryBudget(Integer userId) {
        List<BudgetVo> accList = accountclassifyService.queryAllBudgetVo(null, userId);
        for (BudgetVo acc : accList) {
            acc.setBudgetVoList(accountclassifyService.queryAllTwoAccountClassify(acc.getAccountClassifyId(), userId));
        }
        for (BudgetVo bv : accList) {
            for (Budget budget : bv.getBudgetVoList()) {
                budget.setBudgetNummber((budgetService.queryUserBudget(budget.getAccountClassifyId(), userId) == null ? 0.0 : budgetService.queryUserBudget(budget.getAccountClassifyId(), userId)) - (budgetService.queryUserSumForMonth(budget.getAccountClassifyId(), userId) == null ? 0.0 : budgetService.queryUserSumForMonth(budget.getAccountClassifyId(), userId)));
            }
        }
        return accList;
    }
}
