package com.tan.start.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tan.start.dao.SysUserMapper;
import com.tan.start.entity.SysUser;
import com.tan.start.entity.SysUserExample;
import com.tan.start.service.SysUserService;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;

    private SysUserExample example = new SysUserExample();

    @Override
    public SysUser findByName(String name) {
        example.createCriteria().andUsernameEqualTo(name).andStateEqualTo(1);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
        example.clear();
        if(sysUsers.size() > 0){
            return sysUsers.get(0);
        }
       return null;
    }

    @Override
    public List<SysUser> queryAll() {
        example.setOrderByClause("id asc,state desc");
        System.out.println(example.getOredCriteria());
        return sysUserMapper.selectByExample(example);
    }

}
