package com.simpleaccount.entry;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Billtype implements Serializable {
  private long billTypeId;
  private String billTypeName;
  private Date createtime;
  private Date updatetime;
}
