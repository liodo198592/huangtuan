package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.model.Team;
import com.tencent.wxcloudrun.dao.TeamMapper;
import com.tencent.wxcloudrun.service.ITeamService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 阵容
 * @Author: jeecg-boot
 * @Date:   2024-10-22
 * @Version: V1.0
 */
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team> implements ITeamService {

}
