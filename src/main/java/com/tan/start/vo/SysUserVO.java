package com.tan.start.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tan.start.dto.SysUserDTO;
import com.tan.start.utils.RSAUtils;

import java.util.Date;

public class SysUserVO{
    public SysUserDTO sysUserDTO;

    public SysUserVO(SysUserDTO sysUserDTO) {
        this.sysUserDTO = sysUserDTO;
    }
}
