package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.KaoqinMapper;
import com.tencent.wxcloudrun.model.Kaoqin;
import com.tencent.wxcloudrun.service.KaoqinService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class KaoqinServiceImpl implements KaoqinService {

  final KaoqinMapper kaoqinMapper;

  public KaoqinServiceImpl(@Autowired KaoqinMapper kaoqinMapper) {
    this.kaoqinMapper = kaoqinMapper;
  }

  @Override
  public Optional<Kaoqin> getKaoqin(Integer id) {
    return Optional.ofNullable(kaoqinMapper.getKaoqin(id));
  }

  @Override
  public List<Kaoqin> getAllKaoqin()
  {
    return kaoqinMapper.getAllKaoqin();
  }

  @Override
  public void updateKaoqin(Kaoqin kaoqin) {
    kaoqinMapper.updateKaoqin(kaoqin);
  }

  @Override
  public void deleteKaoqin(Integer id) {
    kaoqinMapper.deleteKaoqin(id);
  }

}
