package com.tencent.wxcloudrun.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.util.oConvertUtils;
import com.tencent.wxcloudrun.model.Team;
import com.tencent.wxcloudrun.service.ITeamService;
import java.util.Date;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

 /**
 * @Description: 阵容
 * @Author: jeecg-boot
 * @Date:   2024-10-22
 * @Version: V1.0
 */
@Slf4j
@Api("阵容")
@RestController
@RequestMapping("/wxcloudrun/team")
public class TeamController {
	@Autowired
	private ITeamService teamService;
	
	/**
	  * 分页列表查询
	 * @param team
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "阵容-分页列表查询")
	@ApiOperation(value="阵容-分页列表查询", notes="阵容-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<Team>> queryPageList(Team team,
									  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
									  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
									  HttpServletRequest req) {
		Result<IPage<Team>> result = new Result<IPage<Team>>();
		QueryWrapper<Team> queryWrapper = QueryGenerator.initQueryWrapper(team, req.getParameterMap());
		Page<Team> page = new Page<Team>(pageNo, pageSize);
		IPage<Team> pageList = teamService.page(page, queryWrapper);
		result.setSuccess(true);
		result.setResult(pageList);
		return result;
	}
	
	/**
	  *   添加
	 * @param team
	 * @return
	 */
	@AutoLog(value = "阵容-添加")
	@ApiOperation(value="阵容-添加", notes="阵容-添加")
	@PostMapping(value = "/add")
	public Result<Team> add(@RequestBody Team team) {
		Result<Team> result = new Result<Team>();
		try {
			teamService.save(team);
			result.success("添加成功！");
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			result.error500("操作失败");
		}
		return result;
	}
	
	/**
	  *  编辑
	 * @param team
	 * @return
	 */
	@AutoLog(value = "阵容-编辑")
	@ApiOperation(value="阵容-编辑", notes="阵容-编辑")
	@PutMapping(value = "/edit")
	public Result<Team> edit(@RequestBody Team team) {
		Result<Team> result = new Result<Team>();
		Team teamEntity = teamService.getById(team.getId());
		if(teamEntity==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = teamService.updateById(team);
			//TODO 返回false说明什么？
			if(ok) {
				result.success("修改成功!");
			}
		}
		
		return result;
	}
	
	/**
	  *   通过id删除
	 * @param id
	 * @return
	 */
	@AutoLog(value = "阵容-通过id删除")
	@ApiOperation(value="阵容-通过id删除", notes="阵容-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<Team> delete(@RequestParam(name="id",required=true) String id) {
		Result<Team> result = new Result<Team>();
		Team team = teamService.getById(id);
		if(team==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = teamService.removeById(id);
			if(ok) {
				result.success("删除成功!");
			}
		}
		
		return result;
	}
	
	/**
	  *  批量删除
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "阵容-批量删除")
	@ApiOperation(value="阵容-批量删除", notes="阵容-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<Team> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		Result<Team> result = new Result<Team>();
		if(ids==null || "".equals(ids.trim())) {
			result.error500("参数不识别！");
		}else {
			this.teamService.removeByIds(Arrays.asList(ids.split(",")));
			result.success("删除成功!");
		}
		return result;
	}
	
	/**
	  * 通过id查询
	 * @param id
	 * @return
	 */
	@AutoLog(value = "阵容-通过id查询")
	@ApiOperation(value="阵容-通过id查询", notes="阵容-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<Team> queryById(@RequestParam(name="id",required=true) String id) {
		Result<Team> result = new Result<Team>();
		Team team = teamService.getById(id);
		if(team==null) {
			result.error500("未找到对应实体");
		}else {
			result.setResult(team);
			result.setSuccess(true);
		}
		return result;
	}

  /**
      * 导出excel
   *
   * @param request
   * @param response
   */
  @RequestMapping(value = "/exportXls")
  public ModelAndView exportXls(HttpServletRequest request, HttpServletResponse response) {
      // Step.1 组装查询条件
      QueryWrapper<Team> queryWrapper = null;
      try {
          String paramsStr = request.getParameter("paramsStr");
          if (oConvertUtils.isNotEmpty(paramsStr)) {
              String deString = URLDecoder.decode(paramsStr, "UTF-8");
              Team team = JSON.parseObject(deString, Team.class);
              queryWrapper = QueryGenerator.initQueryWrapper(team, request.getParameterMap());
          }
      } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
      }

      //Step.2 AutoPoi 导出Excel
      ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
      List<Team> pageList = teamService.list(queryWrapper);
      //导出文件名称
      mv.addObject(NormalExcelConstants.FILE_NAME, "阵容列表");
      mv.addObject(NormalExcelConstants.CLASS, Team.class);
      mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("阵容列表数据", "导出人:Jeecg", "导出信息"));
      mv.addObject(NormalExcelConstants.DATA_LIST, pageList);
      return mv;
  }

  /**
      * 通过excel导入数据
   *
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
  public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
      MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
      Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
      for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
          MultipartFile file = entity.getValue();// 获取上传文件对象
          ImportParams params = new ImportParams();
          params.setTitleRows(2);
          params.setHeadRows(1);
          params.setNeedSave(true);
          try {
              List<Team> listTeams = ExcelImportUtil.importExcel(file.getInputStream(), Team.class, params);
              for (Team teamExcel : listTeams) {
                  teamService.save(teamExcel);
              }
              return Result.ok("文件导入成功！数据行数:" + listTeams.size());
          } catch (Exception e) {
              log.error(e.getMessage(),e);
              return Result.error("文件导入失败:"+e.getMessage());
          } finally {
              try {
                  file.getInputStream().close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
      return Result.ok("文件导入失败！");
  }

}
