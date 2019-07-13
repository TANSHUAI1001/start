package com.tan.start.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.tan.start.config.shiro.ShiroRealm;
import com.tan.start.dao.SysRolePermissionMapper;
import com.tan.start.entity.SysRoleExample;
import com.tan.start.entity.SysRolePermission;
import com.tan.start.entity.SysRolePermissionExample;
import com.tan.start.query.RoleQuery;
import com.tan.start.utils.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisAccessor;
import org.springframework.data.redis.core.RedisCommand;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.tan.start.dao.SysRoleMapper;
import com.tan.start.entity.SysRole;
import com.tan.start.service.SysRoleService;

import javax.annotation.Resource;

@Service
public class SysRoleServiceImpl implements SysRoleService{

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;
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
    public int updateRolePermissionState(Integer roleId, Integer permissionId, Integer state) {
        SysRolePermissionExample example = new SysRolePermissionExample();
        example.createCriteria().andPermissionIdEqualTo(permissionId).andRoleIdEqualTo(roleId);
        SysRolePermission record = new SysRolePermission();
        record.setState(state);
        int rows = sysRolePermissionMapper.updateByExampleSelective(record,example);
        if(rows > 0){
            template.delete("menu:"+roleId);
            realm.getAuthorizationCache().clear();
        }
        return rows;
    }

}
