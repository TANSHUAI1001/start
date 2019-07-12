package com.tan.start.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tan.start.entity.SysUser;
import com.tan.start.utils.RSAUtils;

@JsonIgnoreProperties({"password","salt","singleRole"})
public class SysUserDTO extends SysUser {
    private static final long serialVersionUID = -4896498428027988338L;
    private String roleName;

    public SysUserDTO() {
    }


    @Override
    public void setEmail(String email){
        super.setEmail(RSAUtils.decrypt(email));
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
