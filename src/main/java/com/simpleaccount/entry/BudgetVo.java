package com.simpleaccount.entry;

import lombok.Data;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/5/8 21:23
 * @Version: 1.0
 */
@Data
public class BudgetVo {
    private Integer accountClassifyId;
    private String accountClassifyName;
    private String icon;
    private Double nummber;
    private List<Budget> budgetVoList;
}
