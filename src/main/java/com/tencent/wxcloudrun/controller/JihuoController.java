package com.tencent.wxcloudrun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.JihuoRequest;
import com.tencent.wxcloudrun.model.Jihuo;
import com.tencent.wxcloudrun.service.JihuoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    jihuo.setCreatetime(request.getCreatetime());

    jihuoService.upsertJihuo(jihuo);
    return ApiResponse.ok(jihuo);
  }
  
}