package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Kaoqindetail implements Serializable {

  private Integer id;

  private Integer kaoqinid;

  private String kaoqinuser;

  private String desc;

  private LocalDateTime createtime;

  private Integer isaction;
}
