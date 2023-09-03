package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Jihuodetail;

import java.util.Optional;
import java.util.List;

public interface JihuodetailService {

  Optional<Jihuodetail> getJihuodetail(Integer id);

  List<Jihuodetail> getJihuodetailall();

  void upsertJihuodetail(Jihuodetail jihuodetail);

  void clearJihuodetail(Integer id);
}
