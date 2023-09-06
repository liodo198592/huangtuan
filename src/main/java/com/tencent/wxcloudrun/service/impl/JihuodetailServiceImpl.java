package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.JihuodetailMapper;
import com.tencent.wxcloudrun.model.Jihuodetail;
import com.tencent.wxcloudrun.service.JihuodetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class JihuodetailServiceImpl implements JihuodetailService {

  final JihuodetailMapper jihuodetailMapper;

  public JihuodetailServiceImpl(@Autowired JihuodetailMapper jihuodetailMapper) {
    this.jihuodetailMapper = jihuodetailMapper;
  }

  @Override
  public Optional<Jihuodetail> getJihuodetail(Integer id) {
    return Optional.ofNullable(jihuodetailMapper.getJihuodetail(id));
  }

  @Override
  public List<Jihuodetail>  getJihuodetailbyjihuoid(Integer id){
    return jihuodetailMapper.getJihuodetailbyjihuoid(id);
  }

  @Override
  public List<Jihuodetail> getJihuodetailall() {
    return jihuodetailMapper.getJihuodetailall();
  }

  @Override
  public void upsertJihuodetail(Jihuodetail jihuodetail) {
    jihuodetailMapper.upsertJihuodetail(jihuodetail);
  }

  @Override
  public void clearJihuodetail(Jihuodetail jihuodetail) {
    jihuodetailMapper.clearJihuodetail(jihuodetail);
  }
}
