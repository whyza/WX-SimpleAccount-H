package com.simpleaccount.mapper;

import com.simpleaccount.entry.Budget;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/5/8 20:03
 * @Version: 1.0
 */
public interface BudgetMapper {
    /**
     * 查询用户本月分类消费总额
     * @param userId
     * @return
     */
    Double queryUserSumForMonth(@Param(value = "accountClassifyId")Integer accountClassifyId,@Param(value = "userId")Integer userId);
    /**
     * 查询用户本月分类预算总额
     * @param userId
     * @return
     */
    Double queryUserBudget(@Param(value = "accountClassifyId")Integer accountClassifyId,@Param(value = "userId")Integer userId);


}
