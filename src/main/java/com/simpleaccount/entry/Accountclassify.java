package com.simpleaccount.entry;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accountclassify implements Serializable {
  private long accountClassifyId;
  private String accountClassifyName;
  private long faccountClassifyId;
  private Date createtime;
  private Date updatetime;
}
