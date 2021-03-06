package com.simpleaccount.entry;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.net.ntp.TimeStamp;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill implements Serializable {
  private Long billid;
  private Long userId;
  private Double billMoney;
  private Long accountClassifyId;
  private Long accountTypeId;
  private Long classify;
  private Date date;
  private String address;
  private String remarks;
  private String[] images;
  private java.util.Date createtime;
  private List<BillImages> billImages;
  private Timestamp updatetime;
  private Long accountTypeIdEd;
}
