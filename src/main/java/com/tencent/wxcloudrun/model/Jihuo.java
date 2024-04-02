package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Jihuo implements Serializable {

  private Integer id;

  private Integer posx;

  private Integer posy;

  private String desc;

  private String user;

  private LocalDateTime jihuotime;

  private LocalDateTime createtime;

  private Integer iscalled;
}
