package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Kaoqindetail;

import java.util.Optional;
import java.util.List;

public interface KaoqindetailService {

  Optional<Kaoqindetail> getKaoqindetail(Integer id);

  List<Kaoqindetail>  getKaoqindetailbykaoqinid(Integer id);

  List<Kaoqindetail> getKaoqindetailall();

  void upsertKaoqindetail(Kaoqindetail kaoqindetail);

  void clearKaoqindetail(Kaoqindetail kaoqindetail);
}
