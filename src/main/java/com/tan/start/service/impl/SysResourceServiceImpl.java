package com.tan.start.service.impl;

import com.tan.start.dao.SysResourceMapper;
import com.tan.start.entity.SysResource;
import com.tan.start.entity.SysResourceExample;
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
    public List<SysResource> getMenu() {
        example.createCriteria().andTypeEqualTo("menu").andStateEqualTo(1);
        List<SysResource> menus = sysResourcesMapper.selectByExample(example);
        example.clear();
        return menus;
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
