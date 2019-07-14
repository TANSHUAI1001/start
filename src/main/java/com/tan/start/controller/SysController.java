package com.tan.start.controller;

import com.github.pagehelper.PageHelper;
import com.tan.start.constants.PermissionConstant;
import com.tan.start.dto.RoleResourceDTO;
import com.tan.start.dto.SysResourceDTO;
import com.tan.start.dto.SysUserDTO;
import com.tan.start.entity.SysRole;
import com.tan.start.query.Query;
import com.tan.start.query.RoleQuery;
import com.tan.start.query.datatable.PageParam;
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
        List<SysResourceDTO> resources = sysResourceService.queryAllResource();
        return ResponseContent.ok(resources).putQuery(query);
    }

    @RequestMapping("/role")
    @RequiresPermissions(PermissionConstant.SYSTEM_MENU_MANAGEMENT_ROLE)
    public ResponseContent getRole(RoleQuery roleQuery) {
        PageHelper.offsetPage(roleQuery.getStart(), roleQuery.getLength());
        List<SysRole> roles = sysRoleService.queryAll(roleQuery);
        return ResponseContent.ok(roles).putQuery(roleQuery);
    }

    @RequestMapping("/roleResource")
    @RequiresPermissions(PermissionConstant.SYSTEM_MENU_MANAGEMENT_ROLE)
    public ResponseContent getRolePermission(PageParam pageParam, Integer roleId) {
        PageHelper.offsetPage(pageParam.getStart(), pageParam.getLength());
        List<RoleResourceDTO> roleResources = sysResourceService.getAllResourceByRoleId(roleId);
        return ResponseContent.ok(roleResources).putQuery(pageParam);
    }

    @RequestMapping("/updateRoleResource")
    @RequiresPermissions(PermissionConstant.SYSTEM_MENU_MANAGEMENT_ROLE)
    public ResponseContent updateRolePermission(Integer roleId,Long resourceId,Integer state) {
        int rows = sysRoleService.updateRoleResource(roleId,resourceId,state);
        if(rows <= 0){
            return ResponseContent.fail();
        }
        return ResponseContent.ok();
    }

}
