package com.tan.start.service;

import java.util.List;

import com.tan.start.entity.SysRole;
import com.tan.start.query.RoleQuery;

public interface SysRoleService {

    public List<SysRole> findByUserId(Long userId);

    public SysRole findBySingleRole(Integer singleRoleId);

    List<SysRole> queryAll(RoleQuery roleQuery);
}
