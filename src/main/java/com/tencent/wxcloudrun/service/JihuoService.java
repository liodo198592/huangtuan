package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Jihuo;
import com.tencent.wxcloudrun.model.Member;

import java.util.Optional;
import java.util.List;

public interface JihuoService {

  Optional<Jihuo> getJihuo(Integer id);

  List<Jihuo> getJihuoall();

  void upsertJihuo(Jihuo jihuo);
  
  void updateJihuo(Jihuo jihuo);

  void clearJihuo(Integer id);

  List<Jihuo> getJihuoCallTask(Integer minite);

  List<Member> getcallmember(Integer jihuoid);
}
