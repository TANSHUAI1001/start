package com.tan.start.service;

import com.tan.start.entity.SysUser;

import java.util.List;

public interface SysUserService {

    SysUser findByName(String name);

    List<SysUser> queryAll();
}
