package com.tencent.wxcloudrun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.KaoqindetailInsertRequest;
import com.tencent.wxcloudrun.dto.KaoqindetailRequest;
import com.tencent.wxcloudrun.model.Kaoqindetail;
import com.tencent.wxcloudrun.service.KaoqindetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

/**
 * kaoqindetail控制器
 */
@RestController

public class KaoqindetailController {

  final KaoqindetailService kaoqindetailService;
  final Logger logger;

  public KaoqindetailController(@Autowired KaoqindetailService kaoqindetailService) {
    this.kaoqindetailService = kaoqindetailService;
    this.logger = LoggerFactory.getLogger(KaoqindetailController.class);
  }


  /**
   * 获取考勤数据
   * @return API response json
   */
  @GetMapping(value = "/api/kaoqindetail")
  ApiResponse get(@RequestParam(value = "Id") Integer id) {
    logger.info("/api/kaoqindetail get request");
    Optional<Kaoqindetail> kaoqindetail = kaoqindetailService.getKaoqindetail(id);
    Kaoqindetail kaoqindetailunit = new Kaoqindetail();
    if (kaoqindetail.isPresent()) {
      kaoqindetailunit = kaoqindetail.get();
    }
    return ApiResponse.ok(kaoqindetailunit);
  }

    /**
   * 获取考勤数据
   * @return API response json
   */
  @GetMapping(value = "/api/getKaoqindetailbykaoqinid")
  ApiResponse getKaoqindetailbykaoqinid(@RequestParam(value = "Id") Integer id) {
    logger.info("/api/getKaoqindetailbykaoqinid get request");
    List<Kaoqindetail> kaoqindetail = kaoqindetailService.getKaoqindetailbykaoqinid(id);
    return ApiResponse.ok(kaoqindetail);
  }

    /**
   * 获取集火数据
   * @return API response json
   */
  @GetMapping(value = "/api/kaoqindetailall")
  ApiResponse getall() {
    logger.info("/api/kaoqindetail get request");
    List<Kaoqindetail> kaoqindetail = kaoqindetailService.getKaoqindetailall();
    return ApiResponse.ok(kaoqindetail);
  }

  /**
   * 新增集火
   * @param request {@link KaoqindetailRequest}
   * @return API response json
   */
  @PostMapping(value = "/api/kaoqindetailcreate")
  ApiResponse create(@RequestBody KaoqindetailInsertRequest request) {
    logger.info("/api/kaoqindetailcreate post request, action: {}", request.toString());


    //清理现有数据
    int kaoqinid = request.getKaoqinid();
    Kaoqindetail deleteunit = new Kaoqindetail();
    deleteunit.setKaoqinid(kaoqinid);
    kaoqindetailService.clearKaoqindetail(deleteunit);

    //插入新数据

    List<Kaoqindetail> kaoqindetailList = new ArrayList<>();
    for (KaoqindetailRequest item : request.getKaoqinlist()) {
      Kaoqindetail kaoqindetail = new Kaoqindetail();
      kaoqindetail.setKaoqinid(kaoqinid);
      kaoqindetail.setKaoqinuser(String.valueOf(item.getId()));
      kaoqindetail.setDesc(item.getDesc());
      kaoqindetail.setIsaction(item.getActive());
      kaoqindetail.setCreatetime(LocalDateTime.now());
      kaoqindetailList.add(kaoqindetail);
    }

    kaoqindetailService.insertKaoqinBatch(kaoqindetailList);
    return ApiResponse.ok(kaoqindetailList);
  }
  
}