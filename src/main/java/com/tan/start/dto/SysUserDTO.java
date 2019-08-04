package com.tan.start.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tan.start.entity.SysUser;
import com.tan.start.utils.RSAUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

@JsonIgnoreProperties({"password","salt","singleRole"})
public class SysUserDTO extends SysUser {
    private Logger logger = LoggerFactory.getLogger(SysUserDTO.class);
    private static final long serialVersionUID = -4896498428027988338L;
    private String roleName;

    public SysUserDTO() {
    }

    public SysUserDTO(SysUser user) {
        super();
        try {
            BeanUtils.copyProperties(this,user);
        } catch (IllegalAccessException | InvocationTargetException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void setEmail(String email){
        if(RSAUtils.isBase64(email)){
            super.setEmail(RSAUtils.decrypt(email));
        }else{
            super.setEmail(email);
        }
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
