package com.tencent.wxcloudrun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.KaoqinRequest;
import com.tencent.wxcloudrun.model.Kaoqin;
import com.tencent.wxcloudrun.service.KaoqinService;
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
import java.time.LocalDateTime;
import java.util.List;
import com.alibaba.fastjson.JSON;

/**
 * kaoqin控制器
 */
@RestController
public class KaoqinController {

  final KaoqinService kaoqinService;
  final Logger logger;

  public KaoqinController(@Autowired KaoqinService kaoqinService) {
    this.kaoqinService = kaoqinService;
    this.logger = LoggerFactory.getLogger(KaoqinController.class);
  }


  /**
   * 获取考勤数据
   * @return API response json
   */
  @GetMapping(value = "/api/kaoqin")
  ApiResponse get(@RequestParam(value = "Id") Integer id) {
    logger.info("/api/kaoqin get request");
    Optional<Kaoqin> kaoqin = kaoqinService.getKaoqin(id);
    Kaoqin kaoqinUnit = new Kaoqin();
    if (kaoqin.isPresent()) {
      kaoqinUnit = kaoqin.get();
    }
    return ApiResponse.ok(kaoqinUnit);
  }

    /**
   * 获取考勤数据
   * @return API response json
   */
  @GetMapping(value = "/api/kaoqinall")
  ApiResponse getall() {
    logger.info("/api/kaoqinall get request");
    List<Kaoqin> kaoqin = kaoqinService.getAllKaoqin();
    return ApiResponse.ok(kaoqin);
  }


  /**
   * 新增
   * @param request {@link KaoqinRequest}
   * @return API response json
   */
  @PostMapping(value = "/api/kaoqincreate")
  ApiResponse create(@RequestBody KaoqinRequest request) {
    logger.info("/api/kaoqincreate post request, action: {}", request.toString());

    Kaoqin kaoqin = new Kaoqin();
    kaoqin.setId(request.getId());
    kaoqin.setDesc(request.getDesc());
    kaoqin.setUser(request.getUser());
    kaoqin.setCreatetime(LocalDateTime.now());
    kaoqin.setLimittime(request.getLimittime());

    kaoqinService.insertKaoqin(kaoqin);
    return ApiResponse.ok(kaoqin);
  }
  
}
