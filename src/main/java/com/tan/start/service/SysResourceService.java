package com.tan.start.service;

import com.tan.start.dto.SysResourceDTO;
import com.tan.start.entity.SysResource;

import java.util.List;


public interface SysResourceService {
    List<SysResourceDTO> getMenu();

    List<SysResource> getMenuByRole(Integer roleId);

    List<SysResourceDTO> queryAll();
}
