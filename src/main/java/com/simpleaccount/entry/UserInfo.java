package com.simpleaccount.entry;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {
    private long userId;
    private String userName;
    private String avatarUrl;
    private String country;
    private String province;
    private String city;
    private long gender;
    private String language;
    private long roleId;
    private Date createTime;
    private Date updateTime;
    private String code;
    private String openId;
    private String password;
}
