package com.tan.start.service.impl;

import com.tan.start.dao.SysResourceMapper;
import com.tan.start.dao.SysRoleResourceMapper;
import com.tan.start.entity.*;
import com.tan.start.service.SysResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysResourceServiceImpl implements SysResourceService {

    @Resource
    private SysResourceMapper sysResourcesMapper;
    @Resource
    private SysRoleResourceMapper sysRoleResourceMapper;

    SysResourceExample example = new SysResourceExample();

    @Override
    public List<SysResource> getMenu() {
        example.createCriteria().andTypeEqualTo("menu").andStateEqualTo(1);
        example.setOrderByClause("level asc,priority asc");
        List<SysResource> menus = sysResourcesMapper.selectByExample(example);
        example.clear();
        return menus;
    }

    @Override
    public List<SysResource> getMenuByRole(Integer roleId) {
        example.createCriteria().andTypeEqualTo("menu").andStateEqualTo(1);
        example.setOrderByClause("level asc,priority asc");
        List<SysResource> resources = sysResourcesMapper.selectSysResourceByRoleId(example,roleId);
        example.clear();
        return resources;
    }

    @Override
    public List<SysResource> queryAll() {
        example.createCriteria().andStateEqualTo(1);
        example.setOrderByClause("level asc,priority asc");
        List<SysResource> resources = sysResourcesMapper.selectByExample(example);
        example.clear();
        return resources;
    }
}
