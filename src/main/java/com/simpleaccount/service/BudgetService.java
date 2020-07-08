package com.simpleaccount.service;

import com.simpleaccount.entry.Budget;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/5/8 20:06
 * @Version: 1.0
 */
public interface BudgetService {
    /**
     * 查询用户分类账户预算信息
     * @param accountClassifyId,userId
     * @return
     */
    Double queryUserSumForMonth(Integer accountClassifyId,Integer userId);
    /**
     * 查询用户本月分类预算总额
     * @param userId
     * @return
     */
    Double queryUserBudget(Integer accountClassifyId,Integer userId);
    /**
     * 设置用户预算信息
     * @param budget
     * @return
     */
    Boolean setUserBudget(Budget budget);

    /**
     * 更新用户预算信息
     * @param budget
     * @return
     */
    Boolean updateUserBudget(Budget budget);
    /**
     * 查询用户月消费
     * @param userId
     * @return
     */
    Double selectSumForMonth(Integer userId);
}
