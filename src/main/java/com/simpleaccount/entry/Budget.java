package com.simpleaccount.entry;

import lombok.Data;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/5/8 19:57
 * @Version: 1.0
 */
@Data
public class Budget {
    private Integer accountClassifyId;
    private Long userId;
    private Double budgetNummber;
    private String accountClassifyName;
    private String icon;
}
