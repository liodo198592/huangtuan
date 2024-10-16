package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.MemberMapper;
import com.tencent.wxcloudrun.model.Member;
import com.tencent.wxcloudrun.service.MemberService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

  final MemberMapper memberMapper;

  public MemberServiceImpl(@Autowired MemberMapper memberMapper) {
    this.memberMapper = memberMapper;
  }

  @Override
  public Optional<Member> getMember(Integer id) {
    return Optional.ofNullable(memberMapper.getMember(id));
  }

  @Override
  public Optional<Member> getMemberbyWxrealid(String readid) {
    return Optional.ofNullable(memberMapper.getMemberbyWxrealid(readid));
  }

  @Override
  public List<Member> getMemberall()
  {
    return memberMapper.getMemberall();
  }

  @Override
  public void upsertMember(Member member) {
    memberMapper.upsertMember(member);
  }

  @Override
  public void clearMember(Integer id) {
    memberMapper.clearMember(id);
  }

  @Override
  public String getManage(String openid){
    return memberMapper.getManage(openid);
  }

  @Override
  public void updateRealwxid(Member member){
    member.setWxid(member.getWxrealid().substring(0, 10) + "********" + member.getWxrealid().substring(member.getWxrealid().length() - 8));
    memberMapper.updateRealwxid(member);
  }
}
