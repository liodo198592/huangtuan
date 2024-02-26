package com.tencent.wxcloudrun.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class KaoqindetailRequest {

  private Integer id;

  private Integer kaoqinid;

  private String kaoqinuser;

  private String desc;

  private LocalDateTime createtime;

  private Integer active;

}
