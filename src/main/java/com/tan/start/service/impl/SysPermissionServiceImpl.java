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
		SysRolePermissionExample example = new SysRolePermissionExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		List<SysRolePermission> sysRolePermissions =  sysRolePermissionMapper.selectByExample(example);
		
		List<Integer> permissionIds = sysRolePermissions.stream().map(SysRolePermission::getPermissionId).collect(Collectors.toList());
		
		SysPermissionExample permissionExample = new SysPermissionExample();
		permissionExample.createCriteria().andIdIn(permissionIds);
		List<SysPermission> permissions = sysPermissionMapper.selectByExample(permissionExample);
		return permissions.stream().map(SysPermission::getValue).collect(Collectors.toList());
	}

}
