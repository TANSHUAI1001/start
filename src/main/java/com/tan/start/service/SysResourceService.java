package com.tan.start.service;

import com.tan.start.entity.SysResource;

import java.util.List;


public interface SysResourceService {
    List<SysResource> getMenu();

    List<SysResource> getMenuByRole(Integer roleId);

    List<SysResource> queryAll();
}
