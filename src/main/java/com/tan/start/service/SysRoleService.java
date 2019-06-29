package com.tan.start.service;

import java.util.List;

import com.tan.start.entity.SysRole;

public interface SysRoleService {

    public List<SysRole> findByUserId(Long userId);

    public SysRole findBySingleRole(Integer singleRoleId);
}
