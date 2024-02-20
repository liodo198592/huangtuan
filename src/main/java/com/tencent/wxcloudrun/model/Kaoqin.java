package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Kaoqin implements Serializable {

  private Integer id;

  private String desc;

  private String user;

  private LocalDateTime limittime;

  private LocalDateTime createtime;
  
}
