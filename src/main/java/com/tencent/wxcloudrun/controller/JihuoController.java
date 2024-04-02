package com.tencent.wxcloudrun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.JihuoRequest;
import com.tencent.wxcloudrun.model.Jihuo;
import com.tencent.wxcloudrun.service.JihuoService;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.List;

/**
 * jihuo控制器
 */
@RestController

public class JihuoController {

  final JihuoService jihuoService;
  final Logger logger;

  public JihuoController(@Autowired JihuoService jihuoService) {
    this.jihuoService = jihuoService;
    this.logger = LoggerFactory.getLogger(JihuoController.class);
  }


  /**
   * 获取集火数据
   * @return API response json
   */
  @GetMapping(value = "/api/jihuo")
  ApiResponse get(@RequestParam(value = "Id") Integer id) {
    logger.info("/api/jihuo get request");
    Optional<Jihuo> jihuo = jihuoService.getJihuo(id);
    Jihuo jihuounit = new Jihuo();
    if (jihuo.isPresent()) {
      jihuounit = jihuo.get();
    }
    return ApiResponse.ok(jihuounit);
  }

    /**
   * 获取集火数据
   * @return API response json
   */
  @GetMapping(value = "/api/jihuocrt")
  ApiResponse crt() {
    return ApiResponse.ok("8f7174bcff462394b91c05d441854a20");
  }



    /**
   * 获取集火数据
   * @return API response json
   */
  @GetMapping(value = "/api/jihuoall")
  ApiResponse getall() {
    logger.info("/api/jihuoall get request");
    List<Jihuo> jihuo = jihuoService.getJihuoall();
    return ApiResponse.ok(jihuo);
  }

  /**
   * 新增集火
   * @param request {@link JihuoRequest}
   * @return API response json
   */
  @PostMapping(value = "/api/jihuocreate")
  ApiResponse create(@RequestBody JihuoRequest request) {
    logger.info("/api/jihuocreate post request, action: {}", request.toString());

    Jihuo jihuo = new Jihuo();
    jihuo.setId(request.getId());
    jihuo.setPosx(request.getPosx());
    jihuo.setPosy(request.getPosy());
    jihuo.setDesc(request.getDesc());
    jihuo.setUser(request.getUser());
    jihuo.setJihuotime(request.getJihuotime());
    jihuo.setCreatetime(LocalDateTime.now());
    jihuo.setIscalled(0);

    jihuoService.upsertJihuo(jihuo);
    return ApiResponse.ok(jihuo);
  }

  public String getAccessToken() {
    String appId = "wx6d2ef2da124dc60a";
    String appSecret = "8f7174bcff462394b91c05d441854a20";
    String result = cn.hutool.http.HttpUtil.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret=" + appSecret);
    JSONObject jsonObject = JSONUtil.parseObj(result);
    return jsonObject.getStr("access_token");
  }
      /**
   * 获取集火数据
   * @return API response json
   */
  @GetMapping(value = "/api/jihuocallme")
  ApiResponse callme() {
    JSONObject body=new JSONObject();
    body.set("touser","oJnaT622EzXs_N-JSb5sSoobyrM8");
    body.set("template_id","bX0xY1dNsw9vzC3goYa58XQGv_IxjOwg6wRaAZZYWcY");
    JSONObject json=new JSONObject();
    String time1 = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).toString().replace("T"," ");
    json.set("time1",new JSONObject().set("value",time1));
    json.set("thing2",new JSONObject().set("value", "挂机（123，456）集火"));
    json.set("thing3",new JSONObject().set("value","人呢？开始准备集火！"));
    body.set("data",json);
    //发送
    String accessToken= getAccessToken();
    String post =  cn.hutool.http.HttpUtil.post("https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=" + accessToken, body.toString());
    return ApiResponse.ok(post);
  }
}