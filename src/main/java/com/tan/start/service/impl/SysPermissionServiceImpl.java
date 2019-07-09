package com.tan.start.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tan.start.dao.SysPermissionMapper;
import com.tan.start.dao.SysRolePermissionMapper;
import com.tan.start.entity.SysPermission;
import com.tan.start.entity.SysPermissionExample;
import com.tan.start.entity.SysRolePermission;
import com.tan.start.entity.SysRolePermissionExample;
import com.tan.start.service.SysPermissionService;

@Service
public class SysPermissionServiceImpl implements SysPermissionService{

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;
    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<String> findPermissionsByRoleId(Integer roleId) {
        SysPermissionExample permissionExample = new SysPermissionExample();
        permissionExample.createCriteria().andStateEqualTo(1);
        List<SysPermission> permissions = sysPermissionMapper.selectPermissionByRoleId(permissionExample,roleId);
        return permissions.stream().map(SysPermission::getValue).collect(Collectors.toList());
    }

    @Override
    public List<SysPermission> queryAll() {
        SysPermissionExample permissionExample = new SysPermissionExample();
        permissionExample.createCriteria().andStateEqualTo(1);
        return sysPermissionMapper.selectByExample(permissionExample);
    }

}
