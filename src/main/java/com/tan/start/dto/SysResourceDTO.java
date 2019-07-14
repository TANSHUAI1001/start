package com.tan.start.dto;

import com.tan.start.entity.SysResource;

public class SysResourceDTO extends SysResource {
    private static final long serialVersionUID = -8721764182071674880L;
    private String typeName;
    private String parentName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
