package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

  Member getMember(@Param("id") Integer id);

  Member getMemberbyWxrealid(@Param("wxrealid") String wxrealid);

  String getManage(@Param("openid") String openid);

  List<Member> getMemberall();

  void upsertMember(Member member);

  void clearMember(@Param("id") Integer id);

  void updateRealwxid(Member member);
}
