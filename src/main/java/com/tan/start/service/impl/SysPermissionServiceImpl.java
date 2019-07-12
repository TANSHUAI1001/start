package com.tan.start.service.impl;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.tan.start.dto.RolePermissionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tan.start.dao.SysPermissionMapper;
import com.tan.start.entity.SysPermission;
import com.tan.start.entity.SysPermissionExample;
import com.tan.start.service.SysPermissionService;

@Service
public class SysPermissionServiceImpl implements SysPermissionService{

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<String> findPermissionsByRoleId(Integer roleId) {
        SysPermissionExample permissionExample = new SysPermissionExample();
        List<RolePermissionDTO> permissions = sysPermissionMapper.selectPermissionByRoleId(permissionExample,roleId);
        return permissions.stream().filter(rolePermissionDTO -> rolePermissionDTO.getHasPermission() == 1)
                .map(RolePermissionDTO::getValue).collect(Collectors.toList());
    }

    @Override
    public List<SysPermission> queryAll() {
        SysPermissionExample permissionExample = new SysPermissionExample();
        return sysPermissionMapper.selectByExample(permissionExample);
    }

    @Override
    public List<RolePermissionDTO> findAllPermissionsByRoleId(Integer roleId) {
        SysPermissionExample permissionExample = new SysPermissionExample();
        return sysPermissionMapper.selectPermissionByRoleId(permissionExample,roleId);
    }

}
