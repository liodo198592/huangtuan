package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Jihuodetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface JihuodetailMapper {

  Jihuodetail getJihuodetail(@Param("id") Integer id);

  List<Jihuodetail>  getJihuodetailbyjihuoid(@Param("id") Integer id);

  List<Jihuodetail> getJihuodetailall();

  void upsertJihuodetail(Jihuodetail jihuodetail);

  void clearJihuodetail(Jihuodetail jihuodetail);
}
