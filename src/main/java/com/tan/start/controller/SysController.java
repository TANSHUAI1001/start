package com.tan.start.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tan.start.constants.PermissionConstant;
import com.tan.start.dto.SysUserDTO;
import com.tan.start.entity.SysPermission;
import com.tan.start.entity.SysResource;
import com.tan.start.entity.SysRole;
import com.tan.start.service.SysPermissionService;
import com.tan.start.service.SysResourceService;
import com.tan.start.service.SysRoleService;
import com.tan.start.service.SysUserService;
import com.tan.start.utils.ResponseResult;
import com.tan.start.utils.datatable.PageParam;
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
    public ResponseResult getUser(PageParam pageParam) {
        PageHelper.offsetPage(pageParam.getStart(), pageParam.getLength());
        List<SysUserDTO> sysUsers = sysUserService.queryAll();
        return ResponseResult.ok().
                putBaseAttr(pageParam).
                putAttr(ResponseResult.DATA, sysUsers).
                putAttr(ResponseResult.RECORDS_TOTAL, ((Page) sysUsers).getTotal()).
                putAttr(ResponseResult.RECORDS_FILTERED, ((Page) sysUsers).getTotal());
    }

    @RequestMapping("/resource")
    @RequiresPermissions(PermissionConstant.SYSTEM_MENU_MANAGEMENT_RESOURCE)
    public ResponseResult getResource(PageParam pageParam) {
        PageHelper.offsetPage(pageParam.getStart(), pageParam.getLength());
        List<SysResource> resources = sysResourceService.queryAll();
        long total = ((Page) resources).getTotal();
        return ResponseResult.ok().
                putBaseAttr(pageParam).
                putAttr(ResponseResult.DATA, resources).
                putAttr(ResponseResult.RECORDS_TOTAL, total).
                putAttr(ResponseResult.RECORDS_FILTERED, total);
    }

    @RequestMapping("/role")
    @RequiresPermissions(PermissionConstant.SYSTEM_MENU_MANAGEMENT_ROLE)
    public ResponseResult getRole(PageParam pageParam) {
        PageHelper.offsetPage(pageParam.getStart(), pageParam.getLength());
        List<SysRole> roles = sysRoleService.queryAll();
        long total = ((Page) roles).getTotal();
        return ResponseResult.ok().
                putBaseAttr(pageParam).
                putAttr(ResponseResult.DATA, roles).
                putAttr(ResponseResult.RECORDS_TOTAL, total).
                putAttr(ResponseResult.RECORDS_FILTERED, total);
    }

    @RequestMapping("/permission")
    @RequiresPermissions(PermissionConstant.SYSTEM_MENU_MANAGEMENT_PERMISSION)
    public ResponseResult getPermission(PageParam pageParam) {
        PageHelper.offsetPage(pageParam.getStart(), pageParam.getLength());
        List<SysPermission> permissions = sysPermissionService.queryAll();
        long total = ((Page) permissions).getTotal();
        return ResponseResult.ok().
                putBaseAttr(pageParam).
                putAttr(ResponseResult.DATA, permissions).
                putAttr(ResponseResult.RECORDS_TOTAL, total).
                putAttr(ResponseResult.RECORDS_FILTERED, total);
    }
}
