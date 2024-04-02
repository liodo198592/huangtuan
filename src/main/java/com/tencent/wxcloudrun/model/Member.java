package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Member implements Serializable {

  private Integer id;

  private String name;

  private String wxid;

  private String wxrealid;

  private String manage;

  private Integer delflag;
  
}
