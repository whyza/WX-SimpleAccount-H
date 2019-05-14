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
  private Long accountClassifyId;
  private String accountClassifyName;
  private Long faccountClassifyId;
  private Date createtime;
  private Date updatetime;
  private String icon;
}
