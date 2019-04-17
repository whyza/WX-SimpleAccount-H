package com.simpleaccount.entry;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill implements Serializable {
  private long billid;
  private long userId;
  private long accountClassifyId;
  private long accountTypeId;
  private long classify;
  private Date date;
  private String address;
  private String remarks;
  private String images;
  private Date createtime;
  private Date updatetime;
  private long accountTypeIdEd;
}
