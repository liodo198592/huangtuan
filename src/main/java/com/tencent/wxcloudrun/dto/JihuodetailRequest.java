package com.tencent.wxcloudrun.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class JihuodetailRequest {

  private Integer id;

  private Integer jihuoid;

  private String canyuuser;
  
  private Integer num;

  private String desc;

  private LocalDateTime createtime;

  private Integer isaction;

}
