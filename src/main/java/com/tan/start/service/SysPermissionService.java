package com.tan.start.service;

import java.util.List;

public interface SysPermissionService {

	public List<String> findPermissionsByRoleId(Integer roleId);
}
