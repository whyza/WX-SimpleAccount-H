package com.simpleaccount.service;

import com.simpleaccount.entry.Accountclassify;
import com.simpleaccount.entry.Budget;
import com.simpleaccount.entry.BudgetVo;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/25 7:47
 * @Version: 1.0
 */
public interface AccountclassifyService {
    List<Accountclassify> queryAllAccClassifyInfoByfId(Integer fAccountclassifyId,Integer userId);
    List<BudgetVo> queryAllBudgetVo(Integer fAccountclassifyId, Integer userId);
    List<Budget> queryAllTwoAccountClassify(Integer fAccountclassifyId, Integer userId);
}
