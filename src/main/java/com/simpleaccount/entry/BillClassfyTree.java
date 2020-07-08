package com.simpleaccount.entry;

import com.fasterxml.jackson.annotation.JsonFormat;
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

//    private Integer classfyId;
    //主键自增ID
    private Integer classify;
    //分类名
    private String classfyName;
    //父分类Id
    private Long fClassfyId;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createtime;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date updatetime;
    private String classifyImage;
    private String icon;
    private List<Billclassify> children;
}
