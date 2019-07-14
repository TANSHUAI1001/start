package com.tan.start.service;

import com.tan.start.dto.RoleResourceDTO;
import com.tan.start.dto.SysResourceDTO;
import com.tan.start.entity.SysResource;

import java.util.List;


public interface SysResourceService {
    List<SysResourceDTO> getMenu();

    List<RoleResourceDTO> getMenuByRole(Integer roleId);

    List<SysResourceDTO> queryAllResource();

    List<String> getPermissionsByRoleId(Integer roleId);

    List<RoleResourceDTO> getAllResourceByRoleId(Integer roleId);
}
