package com.tencent.wxcloudrun.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class JihuoRequest {

  private Integer id;

  private Integer posx;

  private Integer posy;

  private String desc;

  private String user;

  private LocalDateTime jihuotime;

  private LocalDateTime createtime;

}
