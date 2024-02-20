package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Kaoqin;

import java.util.Optional;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KaoqinService {

  Optional<Kaoqin> getKaoqin(Integer id);

  List<Kaoqin> getAllKaoqin();

  void updateKaoqin(Kaoqin kaoqin);

  void insertKaoqin(Kaoqin kaoqin);

  void deleteKaoqin(Integer id);
  
}
