package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface MemberMapper {

  Member getMember(@Param("id") Integer id);

  List<Member> getMemberall();

  void upsertMember(Member member);

  void clearMember(@Param("id") Integer id);
}
