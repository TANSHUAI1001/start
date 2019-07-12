package com.tan.start.service.impl;

import java.util.List;

import com.tan.start.entity.SysRoleExample;
import com.tan.start.query.RoleQuery;
import org.apache.commons.lang3.StringUtils;
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
        return null;
    }

    @Override
    public SysRole findBySingleRole(Integer singleRoleId) {
        return sysRoleMapper.selectByPrimaryKey(singleRoleId);
    }

    @Override
    public List<SysRole> queryAll(RoleQuery roleQuery) {
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();
        if(roleQuery.getState() != null){
            criteria.andStateEqualTo(roleQuery.getState());
        }
        if(StringUtils.isNotBlank(roleQuery.getName())){
            criteria.andNameLike("%"+roleQuery.getName()+"%");
        }
        return sysRoleMapper.selectByExample(example);
    }

}
