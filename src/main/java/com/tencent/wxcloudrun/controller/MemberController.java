package com.tencent.wxcloudrun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.MemberRequest;
import com.tencent.wxcloudrun.model.Member;
import com.tencent.wxcloudrun.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.tomcat.util.http.*; 
import java.util.Optional;
import java.util.UUID;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.List;
import com.alibaba.fastjson.JSON;

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
  @GetMapping(value = "/api/memberismanage")
  ApiResponse ismanage(@RequestParam(value = "openid") String openid) {
    logger.info("/api/member get request");
    String member = memberService.getManage(openid);
    return ApiResponse.ok(member);
  }

      /**
   * 获取集火数据
   * @return API response json
   */
  @GetMapping(value = "/api/getcode")
  ApiResponse getcode(@RequestParam(value = "jscode") String jscode) {
    logger.info("/api/getcode get request");
    String url = "https://api.weixin.qq.com/sns/jscode2session?appid={0}&secret={1}&js_code={2}&grant_type=authorization_code";
    String replaceUrl = url.replace("{0}","wx6d2ef2da124dc60a").replace("{1}", "8f7174bcff462394b91c05d441854a20").replace("{2}", jscode);
    
    String content = null;
    URLConnection urlConnection;
    try {
      urlConnection = new URL(replaceUrl).openConnection();
      HttpURLConnection connection = (HttpURLConnection) urlConnection;
      connection.setRequestMethod("GET");
      //连接
      connection.connect();
      //得到响应码
      int responseCode = connection.getResponseCode();
      if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
          (connection.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder bs = new StringBuilder();
        String l;
        while ((l = bufferedReader.readLine()) != null) {
          bs.append(l).append("\n");
        }
        content = bs.toString();
      }
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println(content);
    //需要替换掉key
    
    com.alibaba.fastjson.JSONObject jsonObject =  JSON.parseObject(content);
    jsonObject.remove("session_key");
    System.out.println(jsonObject.toString());
    return ApiResponse.ok(jsonObject.toString());
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
