package com.tencent.wxcloudrun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.MemberRequest;
import com.tencent.wxcloudrun.model.Member;
import com.tencent.wxcloudrun.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.List;

/**
 * member控制器
 */
@RestController

public class MemberController {

  final MemberService memberService;
  final Logger logger;

  public MemberController(@Autowired MemberService memberService) {
    this.memberService = memberService;
    this.logger = LoggerFactory.getLogger(MemberController.class);
  }


  /**
   * 获取集火数据
   * @return API response json
   */
  @GetMapping(value = "/api/member")
  ApiResponse get(@RequestParam(value = "Id") Integer id) {
    logger.info("/api/member get request");
    Optional<Member> member = memberService.getMember(id);
    Member memberunit = new Member();
    if (member.isPresent()) {
      memberunit = member.get();
    }
    return ApiResponse.ok(memberunit);
  }

    /**
   * 获取集火数据
   * @return API response json
   */
  @GetMapping(value = "/api/memberall")
  ApiResponse getall() {
    logger.info("/api/memberall get request");
    List<Member> member = memberService.getMemberall();
    return ApiResponse.ok(member);
  }


  /**
   * 新增集火
   * @param request {@link MemberRequest}
   * @return API response json
   */
  @PostMapping(value = "/api/membercreate")
  ApiResponse create(@RequestBody MemberRequest request) {
    logger.info("/api/membercreate post request, action: {}", request.toString());

    Member member = new Member();
    member.setId(request.getId());
    member.setName(request.getName());
    member.setWxid(request.getWxid());
    member.setManage(request.getManage());

    memberService.upsertMember(member);
    return ApiResponse.ok(member);
  }
  
}