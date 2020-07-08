package com.simpleaccount.entry;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 *
 * @Description: 账单分类
 * @auther: LS
 * @date: 2019/4/23 10:33
 */
@Data
public class Billclassify implements Serializable {
    private Long fClassfyId;
    private String icon;
    private Long classify;
    private String classfyName;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createtime;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updatetime;
    private String classifyImage;
    private Integer userId;
    private Integer classifyType;
}
