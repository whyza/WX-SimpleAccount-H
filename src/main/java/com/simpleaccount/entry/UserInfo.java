package com.simpleaccount.entry;
import lombok.Data;

import java.util.Date;
@Data
public class UserInfo {
    private Integer userid;

    private String username;

    private String password;

    private String usericon;

    private String uemail;

    private Date registertime;

    private Integer userstatus;

    private Integer userrole;
}