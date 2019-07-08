package com.tan.start.service;

import com.tan.start.entity.SysPermission;

import java.util.List;

public interface SysPermissionService {

    public List<String> findPermissionsByRoleId(Integer roleId);

    List<SysPermission> queryAll();
}
