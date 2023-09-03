package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.JihuoMapper;
import com.tencent.wxcloudrun.model.Jihuo;
import com.tencent.wxcloudrun.service.JihuoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class JihuoServiceImpl implements JihuoService {

  final JihuoMapper jihuoMapper;

  public JihuoServiceImpl(@Autowired JihuoMapper jihuoMapper) {
    this.jihuoMapper = jihuoMapper;
  }

  @Override
  public Optional<Jihuo> getJihuo(Integer id) {
    return Optional.ofNullable(jihuoMapper.getJihuo(id));
  }

  @Override
  public void upsertJihuo(Jihuo jihuo) {
    countersMapper.upsertCount(jihuo);
  }

  @Override
  public void clearJihuo(Integer id) {
    jihuoMapper.clearJihuo(id);
  }
}
