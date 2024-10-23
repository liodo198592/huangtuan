package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.model.Member;
import com.tencent.wxcloudrun.model.Team;
import com.tencent.wxcloudrun.dao.MemberMapper;
import com.tencent.wxcloudrun.dao.TeamMapper;
import com.tencent.wxcloudrun.service.ITeamService;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 阵容
 * @Author: jeecg-boot
 * @Date:   2024-10-22
 * @Version: V1.0
 */
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team> implements ITeamService {
  final TeamMapper teamMapper;

  public TeamServiceImpl(@Autowired TeamMapper teamMapper) {
    this.teamMapper = teamMapper;
  }

  @Override
  public IPage<Team> getTeambyname(Page<Team> page, String name)
  {
    return teamMapper.getTeambyname(page,name);
  }
}
