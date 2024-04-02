package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Jihuo;
import com.tencent.wxcloudrun.model.Member;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface JihuoMapper {

  Jihuo getJihuo(@Param("id") Integer id);

  List<Jihuo> getJihuoall();


  List<Jihuo> getJihuoCallTask(Integer minite);
  
  void upsertJihuo(Jihuo jihuo);

  void updateJihuo(Jihuo jihuo);

  void clearJihuo(@Param("id") Integer id);

  List<Member> getcallmember(Integer jihuoid);
}
