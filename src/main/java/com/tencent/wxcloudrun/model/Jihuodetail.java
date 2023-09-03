package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Jihuodetail implements Serializable {

  private Integer id;

  private Integer jihuoid;

  private String canyuuser;
  
  private Integer num;

  private String desc;

  private LocalDateTime createtime;

  private Integer isaction;
}
