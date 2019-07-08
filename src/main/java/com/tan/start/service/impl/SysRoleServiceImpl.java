package com.tan.start.service.impl;

import java.util.List;

import com.tan.start.entity.SysRoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tan.start.dao.SysRoleMapper;
import com.tan.start.entity.SysRole;
import com.tan.start.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService{

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> findByUserId(Long userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SysRole findBySingleRole(Integer singleRoleId) {
        return sysRoleMapper.selectByPrimaryKey(singleRoleId);
    }

    @Override
    public List<SysRole> queryAll() {
        SysRoleExample example = new SysRoleExample();
        example.createCriteria().andStateEqualTo(1);
        return sysRoleMapper.selectByExample(example);
    }

}
