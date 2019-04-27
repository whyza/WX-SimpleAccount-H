package com.simpleaccount.entry;

import lombok.Data;

import java.sql.Date;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/25 18:31
 * @Version: 1.0
 */
@Data
public class DateBills {
    private Date date;
    private List<BillVo> dateBills;
}
