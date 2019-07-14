package com.tan.start.dto;

import com.tan.start.entity.SysResource;
import com.tan.start.entity.SysRoleResource;


public class RoleResourceDTO extends SysResource {
    private static final long serialVersionUID = 5976026575348300819L;
    private SysRoleResource sysRoleResource;

    public SysRoleResource getSysRoleResource() {
        return sysRoleResource;
    }

    public void setSysRoleResource(SysRoleResource sysRoleResource) {
        this.sysRoleResource = sysRoleResource;
    }
}
