package com.simpleaccount.service.impl;

import com.simpleaccount.entry.Accountclassify;
import com.simpleaccount.entry.Budget;
import com.simpleaccount.entry.BudgetVo;
import com.simpleaccount.mapper.AccountclassifyMapper;
import com.simpleaccount.service.AccountclassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/25 7:48
 * @Version: 1.0
 */
@Service
public class AccountclassifyServiceImpl  implements AccountclassifyService {
    @Autowired
    AccountclassifyMapper AccountclassifyMapper;
    @Override
    public List<Accountclassify> queryAllAccClassifyInfoByfId(Integer fAccountclassifyId,Integer userId) {
        return AccountclassifyMapper.queryAllAccClassifyInfoByfId(fAccountclassifyId,userId);
    }

    @Override
    public List<BudgetVo> queryAllBudgetVo(Integer fAccountclassifyId, Integer userId) {
        return AccountclassifyMapper.queryAllBudgetVo(fAccountclassifyId,userId);
    }

    @Override
    public List<Budget> queryAllTwoAccountClassify(Integer fAccountclassifyId, Integer userId) {
        return AccountclassifyMapper.queryAllTwoAccountClassify(fAccountclassifyId, userId);
    }
}
