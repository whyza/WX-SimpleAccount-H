package com.simpleaccount.service.impl;

import com.simpleaccount.entry.Budget;
import com.simpleaccount.mapper.BillMapper;
import com.simpleaccount.mapper.BudgetMapper;
import com.simpleaccount.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/5/8 20:07
 * @Version: 1.0
 */
@Service
public class BudgetServiceImpl implements BudgetService {
    @Autowired
    BudgetMapper budgetMapper;

    /**
     * 查询用户分类账户预算信息
     *
     * @param userId
     * @return
     */
    @Override
    public Double queryUserSumForMonth(Integer accountClassifyId,Integer userId) {
        return budgetMapper.queryUserSumForMonth(accountClassifyId,userId);
    }

    /**
     * 查询用户本月分类预算总额
     *
     * @param accountClassifyId
     * @param userId
     * @return
     */
    @Override
    public Double queryUserBudget(Integer accountClassifyId, Integer userId) {
        return budgetMapper.queryUserBudget(accountClassifyId,userId);
    }

    /**
     * 设置用户预算信息
     *
     * @param budget
     * @return
     */
    @Override
    public Boolean setUserBudget(Budget budget) {
        return budgetMapper.setUserBudget(budget)>0;
    }

    /**
     * 更新用户预算信息
     *
     * @param budget
     * @return
     */
    @Override
    public Boolean updateUserBudget(Budget budget) {
        return budgetMapper.updateUserBudget(budget)>0;
    }

    /**
     * 查询用户月消费
     *
     * @param userId
     * @return
     */
    @Override
    public Double selectSumForMonth(Integer userId) {
        return budgetMapper.selectSumForMonth(userId);
    }
}
