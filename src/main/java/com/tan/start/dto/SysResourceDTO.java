package com.tan.start.dto;

import com.tan.start.entity.SysResource;

public class SysResourceDTO extends SysResource {
    private String type;
    private String typeName;
    private String parentName;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
        switch (type){
            case "menu": this.setTypeName("菜单");break;
            default:this.setTypeName(type);
        }
    }

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
