package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.KaoqindetailMapper;
import com.tencent.wxcloudrun.model.Kaoqindetail;
import com.tencent.wxcloudrun.service.KaoqindetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class KaoqindetailServiceImpl implements KaoqindetailService {

  final KaoqindetailMapper kaoqindetailMapper;

  public KaoqindetailServiceImpl(@Autowired KaoqindetailMapper kaoqindetailMapper) {
    this.kaoqindetailMapper = kaoqindetailMapper;
  }

  @Override
  public Optional<Kaoqindetail> getKaoqindetail(Integer id) {
    return Optional.ofNullable(kaoqindetailMapper.getKaoqindetail(id));
  }

  @Override
  public List<Kaoqindetail>  getKaoqindetailbykaoqinid(Integer id){
    return kaoqindetailMapper.getKaoqindetailbykaoqinid(id);
  }

  @Override
  public void insertKaoqinBatch(List<Kaoqindetail> list){
    kaoqindetailMapper.insertKaoqinBatch(list);
  }

  @Override
  public List<Kaoqindetail> getKaoqindetailall() {
    return kaoqindetailMapper.getKaoqindetailall();
  }

  @Override
  public void upsertKaoqindetail(Kaoqindetail kaoqindetail) {
    kaoqindetailMapper.upsertKaoqindetail(kaoqindetail);
  }

  @Override
  public void clearKaoqindetail(Kaoqindetail kaoqindetail) {
    kaoqindetailMapper.clearKaoqindetail(kaoqindetail);
  }
}
