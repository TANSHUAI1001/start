package com.tan.start.service;

import com.tan.start.dto.RolePermissionDTO;
import com.tan.start.entity.SysPermission;

import java.util.List;

public interface SysPermissionService {

    List<String> findPermissionsByRoleId(Integer roleId);

    List<SysPermission> queryAll();

    List<RolePermissionDTO> findAllPermissionsByRoleId(Integer roleId);
}
