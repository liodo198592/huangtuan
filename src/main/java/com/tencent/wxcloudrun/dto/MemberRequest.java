package com.tencent.wxcloudrun.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MemberRequest {

  private Integer id;

  private String name;

  private String wxid;

  private String manage;
}
