package com.simpleaccount.entry;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/28 9:24
 * @Version: 1.0
 */
@Data
public class BillDetailsVo implements Serializable {
    private Long billid;
//    private Long userId;
    private Double billMoney;
    private Long classify;
    private Long accountClassifyId;
    private String accountClassifyName;
    private Long accountTypeId;
    private java.sql.Date date;
    private String address;
    private String remarks;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private java.util.Date  createtime;
    private List<String> billImages;
    private java.util.Date   updatetime;
    private Long accountTypeIdEd;
    /**
     * 账单分类属性
     */
    private String classfyName;
    private String classifyImage;
}
