package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Team;



import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 阵容
 * @Author: jeecg-boot
 * @Date:   2024-10-22
 * @Version: V1.0
 */
public interface ITeamService extends IService<Team> {
    public IPage<Team> getTeambyname(Page<Team> page, String name);
}
