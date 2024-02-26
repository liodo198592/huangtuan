package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Kaoqindetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface KaoqindetailMapper {

  Kaoqindetail getKaoqindetail(@Param("id") Integer id);

  List<Kaoqindetail>  getKaoqindetailbykaoqinid(@Param("id") Integer id);

  List<Kaoqindetail> getKaoqindetailall();

  void upsertKaoqindetail(Kaoqindetail kaoqindetail);

  void clearKaoqindetail(Kaoqindetail kaoqindetail);

  void insertKaoqinBatch(List<Kaoqindetail> list);
}
