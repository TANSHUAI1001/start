package com.tan.start.controller;

import com.github.pagehelper.PageHelper;
import com.tan.start.constants.PermissionConstant;
import com.tan.start.dto.RolePermissionDTO;
import com.tan.start.dto.SysUserDTO;
import com.tan.start.entity.SysPermission;
import com.tan.start.entity.SysResource;
import com.tan.start.entity.SysRole;
import com.tan.start.query.Query;
import com.tan.start.query.RoleQuery;
import com.tan.start.service.SysPermissionService;
import com.tan.start.service.SysResourceService;
import com.tan.start.service.SysRoleService;
import com.tan.start.service.SysUserService;
import com.tan.start.utils.ResponseContent;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sys")
public class SysController {

    private Logger logger = LoggerFactory.getLogger(SysController.class);

    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysRoleService sysRoleService;
    @Resource
    private SysPermissionService sysPermissionService;
    @Resource
    private SysResourceService sysResourceService;

    @RequestMapping("/user")
    @RequiresPermissions(PermissionConstant.SYSTEM_MENU_MANAGEMENT_USER)
    public ResponseContent getUser(Query query) {
        PageHelper.offsetPage(query.getStart(), query.getLength());
        List<SysUserDTO> sysUsers = sysUserService.queryAll();
        return ResponseContent.ok(sysUsers).putQuery(query);
    }

    @RequestMapping("/resource")
    @RequiresPermissions(PermissionConstant.SYSTEM_MENU_MANAGEMENT_RESOURCE)
    public ResponseContent getResource(Query query) {
        PageHelper.offsetPage(query.getStart(), query.getLength());
        List<SysResource> resources = sysResourceService.queryAll();
        return ResponseContent.ok(resources).putQuery(query);
    }

    @RequestMapping("/role")
    @RequiresPermissions(PermissionConstant.SYSTEM_MENU_MANAGEMENT_ROLE)
    public ResponseContent getRole(RoleQuery roleQuery) {
        PageHelper.offsetPage(roleQuery.getStart(), roleQuery.getLength());
        List<SysRole> roles = sysRoleService.queryAll(roleQuery);
        return ResponseContent.ok(roles).putQuery(roleQuery);
    }

    @RequestMapping("/rolePermission")
    @RequiresPermissions(PermissionConstant.SYSTEM_MENU_MANAGEMENT_ROLE)
    public ResponseContent getRolePermission(RoleQuery roleQuery,Integer roleId) {
        PageHelper.offsetPage(roleQuery.getStart(), roleQuery.getLength());
        List<RolePermissionDTO> permissions = sysPermissionService.findAllPermissionsByRoleId(roleId);
        return ResponseContent.ok(permissions).putQuery(roleQuery);
    }

    @RequestMapping("/permission")
    @RequiresPermissions(PermissionConstant.SYSTEM_MENU_MANAGEMENT_PERMISSION)
    public ResponseContent getPermission(Query query) {
        PageHelper.offsetPage(query.getStart(), query.getLength());
        List<SysPermission> permissions = sysPermissionService.queryAll();
        return ResponseContent.ok(permissions).putQuery(query);
    }
}
