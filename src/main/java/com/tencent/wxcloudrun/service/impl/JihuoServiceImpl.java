package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.JihuoMapper;
import com.tencent.wxcloudrun.model.Jihuo;
import com.tencent.wxcloudrun.model.Member;
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
  public List<Jihuo> getJihuoCallTask(Integer minite) {
    return jihuoMapper.getJihuoCallTask(minite);
  }

  @Override
  public List<Jihuo> getJihuoall()
  {
    return jihuoMapper.getJihuoall();
  }

  @Override
  public void upsertJihuo(Jihuo jihuo) {
    jihuoMapper.upsertJihuo(jihuo);
  }

  @Override
  public void updateJihuo(Jihuo jihuo){
    jihuoMapper.updateJihuo(jihuo);
  }

  @Override
  public void clearJihuo(Integer id) {
    jihuoMapper.clearJihuo(id);
  }

  @Override
  public List<Member> getcallmember(Integer jihuoid)
  {
    return jihuoMapper.getcallmember(jihuoid);
  }
}
