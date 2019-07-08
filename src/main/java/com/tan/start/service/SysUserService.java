package com.tan.start.service;

import com.tan.start.dto.SysUserDTO;
import com.tan.start.entity.SysUser;

import java.util.List;

public interface SysUserService {

    SysUser findByName(String name);

    List<SysUserDTO> queryAll();

    int updatePasswordById(Long id, String md5PasswordWithSalt);

    int updateUserInfo(SysUser user);

    SysUser findById(Long id);
}
