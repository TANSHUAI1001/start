package com.tan.start.dto;

import com.tan.start.entity.SysPermission;


public class RolePermissionDTO extends SysPermission {
    private static final long serialVersionUID = 5976026575348300819L;
    private Integer hasPermission;

    public Integer getHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(Integer hasPermission) {
        this.hasPermission = hasPermission;
    }
}
