package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Jihuo;

import java.util.Optional;
import java.util.List;

public interface JihuoService {

  Optional<Jihuo> getJihuo(Integer id);

  List<Jihuo> getJihuoall();

  void upsertJihuo(Jihuo jihuo);

  void clearJihuo(Integer id);
}
