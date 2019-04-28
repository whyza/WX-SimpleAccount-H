package com.simpleaccount.entry;

import lombok.Data;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/25 19:36
 * @Version: 1.0
 */
@Data
public class BillVo {
    private Long billid;
    private Double billMoney;
    private String remarks;
    private Long accountTypeId;
    private String classfyName;
    private String classifyImage;
    private java.util.Date createtime;
    private List<BillImages> billImages;
}
