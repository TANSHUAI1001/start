package com.tan.start.service.impl;

import com.tan.start.dao.SysResourceMapper;
import com.tan.start.dto.RoleResourceDTO;
import com.tan.start.dto.SysResourceDTO;
import com.tan.start.entity.SysResource;
import com.tan.start.entity.SysResourceExample;
import com.tan.start.service.SysResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysResourceServiceImpl implements SysResourceService {

    @Resource
    private SysResourceMapper sysResourceMapper;

    SysResourceExample example = new SysResourceExample();

    @Override
    public List<SysResourceDTO> getMenu() {
        example.createCriteria().andTypeEqualTo("menu").andStateEqualTo(1);
        example.setOrderByClause("sys_resource.level asc,sys_resource.priority asc");
        List<SysResourceDTO> menus = sysResourceMapper.selectByExample(example);
        example.clear();
        return menus;
    }

    @Override
    public List<RoleResourceDTO> getMenuByRole(Integer roleId) {
        example.createCriteria().andTypeEqualTo("menu").andStateEqualTo(1);
        example.setOrderByClause("sys_resource.level asc,sys_resource.priority asc");
        List<RoleResourceDTO> resources = sysResourceMapper.selectSysResourceByRoleId(example,roleId,true);
        example.clear();
        return resources;
    }

    @Override
    public List<SysResourceDTO> queryAllResource() {
        example.createCriteria().andStateEqualTo(1);
        example.setOrderByClause("sys_resource.level asc,sys_resource.priority asc");
        List<SysResourceDTO> resources = sysResourceMapper.selectByExample(example);
        example.clear();
        return resources;
    }

    //fix problem: getPermissionsByRoleId和getAllResourceByRoleId都调用selectSysResourceByRoleId，频繁操作会
    // 到导致MyBatisSystemException PersistenceException ConcurrentModificationException
    @Override
    public List<String> getPermissionsByRoleId(Integer roleId) {
        example.createCriteria().andStateEqualTo(1);
        List<RoleResourceDTO> resources;
        synchronized (SysResourceServiceImpl.class){
            resources = sysResourceMapper.selectSysResourceByRoleId(example,roleId,true);
        }

        example.clear();
        return resources.stream().map(SysResource::getPermission).collect(Collectors.toList());
    }

    @Override
    public List<RoleResourceDTO> getAllResourceByRoleId(Integer roleId) {
        example.createCriteria().andStateEqualTo(1);
        example.setOrderByClause("sys_resource.level asc,sys_resource.priority asc");
        List<RoleResourceDTO> resources;
        synchronized (SysResourceServiceImpl.class) {
            resources = sysResourceMapper.selectSysResourceByRoleId(example, roleId, null);
        }
        example.clear();
        return resources;
    }

}
