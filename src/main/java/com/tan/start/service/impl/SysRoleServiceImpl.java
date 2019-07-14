package com.tan.start.service.impl;

import java.util.List;

import com.tan.start.config.shiro.ShiroRealm;
import com.tan.start.dao.SysRoleResourceMapper;
import com.tan.start.entity.*;
import com.tan.start.query.RoleQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.tan.start.dao.SysRoleMapper;
import com.tan.start.service.SysRoleService;

import javax.annotation.Resource;

@Service
public class SysRoleServiceImpl implements SysRoleService{

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRoleResourceMapper sysRoleResourceMapper;
    @Resource(name = "redisTemplate")
    private RedisTemplate<Object, Object> template;
    @Resource
    private ShiroRealm realm;

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

    @Override
    public int updateRoleResource(Integer roleId, Long resourceId, Integer state) {
        SysRoleResourceExample example = new SysRoleResourceExample();
        example.createCriteria().andResourceIdEqualTo(resourceId).andRoleIdEqualTo(roleId);
        SysRoleResource record = new SysRoleResource();
        record.setAvailable(state == 1);
        int rows = sysRoleResourceMapper.updateByExampleSelective(record,example);
        if(rows > 0){
            template.delete("menu:"+roleId);
            realm.getAuthorizationCache().clear();
        }
        return rows;
    }

}
