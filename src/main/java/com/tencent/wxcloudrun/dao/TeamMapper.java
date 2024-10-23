package com.tencent.wxcloudrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tencent.wxcloudrun.model.Member;
import com.tencent.wxcloudrun.model.Team;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @Description: 阵容
 * @Author: jeecg-boot
 * @Date:   2024-10-22
 * @Version: V1.0
 */
public interface TeamMapper extends BaseMapper<Team> {
    IPage<Team> getTeambyname(Page<Team> page, String name);
}
