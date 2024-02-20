package com.tencent.wxcloudrun.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class KaoqinRequest {

  private Integer id;

  private String desc;

  private String user;

  private LocalDateTime limittime;

  private LocalDateTime createtime;
}
