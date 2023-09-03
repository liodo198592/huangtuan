package com.tencent.wxcloudrun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.JihuodetailRequest;
import com.tencent.wxcloudrun.model.Jihuodetail;
import com.tencent.wxcloudrun.service.JihuodetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

/**
 * jihuodetail控制器
 */
@RestController

public class JihuodetailController {

  final JihuodetailService jihuodetailService;
  final Logger logger;

  public JihuodetailController(@Autowired JihuodetailService jihuodetailService) {
    this.jihuodetailService = jihuodetailService;
    this.logger = LoggerFactory.getLogger(JihuodetailController.class);
  }


  /**
   * 获取集火数据
   * @return API response json
   */
  @GetMapping(value = "/api/jihuodetail")
  ApiResponse get() {
    logger.info("/api/jihuodetail get request");
    Optional<Jihuodetail> jihuodetail = jihuodetailService.getJihuodetail(1);
    Jihuodetail jihuodetailunit = new Jihuodetail();
    if (jihuodetail.isPresent()) {
      jihuodetailunit = jihuodetail.get();
    }
    return ApiResponse.ok(jihuodetailunit);
  }

    /**
   * 获取集火数据
   * @return API response json
   */
  @GetMapping(value = "/api/jihuodetailall")
  ApiResponse getall() {
    logger.info("/api/jihuodetail get request");
    List<Jihuodetail> jihuodetail = jihuodetailService.getJihuodetailall();
    return ApiResponse.ok(jihuodetail);
  }

  /**
   * 新增集火
   * @param request {@link JihuodetailRequest}
   * @return API response json
   */
  @PostMapping(value = "/api/jihuodetail")
  ApiResponse create(@RequestBody JihuodetailRequest request) {
    logger.info("/api/jihuodetail post request, action: {}", request.toString());

    Jihuodetail jihuodetail = new Jihuodetail();

    jihuodetail.setId(request.getId());
    jihuodetail.setJihuoid(request.getJihuoid());
    jihuodetail.setNum(request.getNum());
    jihuodetail.setDesc(request.getDesc());
    jihuodetail.setCreatetime(request.getCreatetime());
    jihuodetail.setIsaction(request.getIsaction());

    jihuodetailService.upsertJihuodetail(jihuodetail);
    return ApiResponse.ok(jihuodetail);
  }
  
}