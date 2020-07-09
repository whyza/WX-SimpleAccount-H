package com.simpleaccount.controller;

import com.simpleaccount.entry.Budget;
import com.simpleaccount.entry.BudgetVo;
import com.simpleaccount.service.AccountclassifyService;
import com.simpleaccount.service.BudgetService;
import com.simpleaccount.util.resultutil.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/25 7:58
 * @Version: 1.0
 */
@Controller
public class AccountclassifyController {
    @Resource
    AccountclassifyService accountclassifyService;
    @Resource
    BudgetService budgetService;

    @ApiOperation(value = "根据fAccountclassifyId查询账户信息", notes = "根据fAccountclassifyId查询账户信息")
    @RequestMapping(value = "queryAccClassifyInfoByfId",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ResultUtil<List<com.simpleaccount.entry.Accountclassify>> queryAccClassifyInfoByfId(Integer fAccountclassifyId, Integer userId) {
        return new ResultUtil<>("请求成功", accountclassifyService.queryAllAccClassifyInfoByfId(fAccountclassifyId, userId));
    }

    @RequestMapping(value = "queryBudget",method = {RequestMethod.GET,RequestMethod.POST})
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
