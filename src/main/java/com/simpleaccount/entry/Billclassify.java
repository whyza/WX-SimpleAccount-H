package com.simpleaccount.entry;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Billclassify {
    private Integer classfyId;
    private long classify;
    private String classfyName;
    private long fClassfyId;
    private Date createtime;
    private Date updatetime;
    private String classifyImage;
    private Integer userId;
}
