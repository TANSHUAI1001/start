package com.tan.start.service.impl;

import com.tan.start.dao.SysResourceMapper;
import com.tan.start.dto.SysResourceDTO;
import com.tan.start.entity.*;
import com.tan.start.service.SysResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysResourceServiceImpl implements SysResourceService {

    @Resource
    private SysResourceMapper sysResourcesMapper;

    SysResourceExample example = new SysResourceExample();

    @Override
    public List<SysResourceDTO> getMenu() {
        example.createCriteria().andTypeEqualTo("menu").andStateEqualTo(1);
        example.setOrderByClause("sys_resource.level asc,sys_resource.priority asc");
        List<SysResourceDTO> menus = sysResourcesMapper.selectByExample(example);
        example.clear();
        return menus;
    }

    @Override
    public List<SysResource> getMenuByRole(Integer roleId) {
        example.createCriteria().andTypeEqualTo("menu").andStateEqualTo(1);
        example.setOrderByClause("sys_resource.level asc,sys_resource.priority asc");
        List<SysResource> resources = sysResourcesMapper.selectSysResourceByRoleId(example,roleId);
        example.clear();
        return resources;
    }

    @Override
    public List<SysResourceDTO> queryAll() {
        example.createCriteria().andStateEqualTo(1);
        example.setOrderByClause("sys_resource.level asc,sys_resource.priority asc");
        List<SysResourceDTO> resources = sysResourcesMapper.selectByExample(example);
        example.clear();
        return resources;
    }
}
