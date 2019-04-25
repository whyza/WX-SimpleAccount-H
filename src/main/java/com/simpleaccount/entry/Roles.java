package com.simpleaccount.entry;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Roles implements Serializable {
  private Long roleId;
  private String roleName;
  private Date createTime;
  private Date updateTime;
}
