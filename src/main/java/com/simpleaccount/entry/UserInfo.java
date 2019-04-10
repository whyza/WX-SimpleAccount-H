package com.simpleaccount.entry;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class UserInfo implements Serializable {
    private Integer userid;

    private String username;

    private String password;

    private String usericon;

    private String uemail;

    private Date registertime;

    private Integer userstatus;

    private Integer userrole;
}