package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Jihuodetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface JihuodetailMapper {

  Counter getJihuodetail(@Param("id") Integer id);

  void upsertJihuodetail(Jihuodetail jihuodetail);

  void clearJihuodetail(@Param("id") Integer id);
}
