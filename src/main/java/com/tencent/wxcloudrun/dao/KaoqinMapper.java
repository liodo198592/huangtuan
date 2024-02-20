package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Kaoqin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface KaoqinMapper {

  Kaoqin getKaoqin(@Param("id") Integer id);

  List<Kaoqin> getAllKaoqin();

  void updateKaoqin(Kaoqin kaoqin);


  void insertKaoqin(Kaoqin kaoqin);

  void deleteKaoqin(@Param("id") Integer id);
}
