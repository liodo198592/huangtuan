package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Member;

import java.util.Optional;
import java.util.List;

public interface MemberService {

  Optional<Member> getMember(Integer id);

  List<Member> getMemberall();

  void upsertMember(Member member);

  void clearMember(Integer id);
}
