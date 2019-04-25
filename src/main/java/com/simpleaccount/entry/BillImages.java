package com.simpleaccount.entry;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/25 13:17
 * @Version: 1.0
 */
@Data
public class BillImages implements Serializable {
    private Integer imageId;
    private String imageUrl;
}
