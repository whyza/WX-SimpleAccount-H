package com.simpleaccount.entry;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Suggestandback implements Serializable {
  private Long suggestId;
  private Long suggestType;
  private String suggestContent;
  private Date createtime;
  private Date updatetime;
}
