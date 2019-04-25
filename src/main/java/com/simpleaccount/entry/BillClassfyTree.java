package com.simpleaccount.entry;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/21 17:45
 * @Version: 1.0
 */
@Data
public class BillClassfyTree implements Serializable {

    private Integer classfyId;
    //主键自增ID
    private Long classify;
    //分类名
    private String classfyName;
    //父分类Id
    private Long fClassfyId;
    private Date createtime;
    private Date updatetime;
    private String classifyImage;
    private List<Billclassify> ChildrenBillClassfy;
}
