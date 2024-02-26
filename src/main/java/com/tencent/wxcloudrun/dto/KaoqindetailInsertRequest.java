package com.tencent.wxcloudrun.dto;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class KaoqindetailInsertRequest {

  private Integer kaoqinid;

  private List<KaoqindetailRequest> kaoqinlist;

}
