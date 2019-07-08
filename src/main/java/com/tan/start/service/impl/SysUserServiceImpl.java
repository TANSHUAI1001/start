package com.tan.start.service.impl;

import com.tan.start.dto.SysUserDTO;
import com.tan.start.utils.RSAUtils;
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
            SysUser user = sysUsers.get(0);
            user.setEmail(RSAUtils.decrypt(user.getEmail()));
            return user;
        }
       return null;
    }

    @Override
    public List<SysUserDTO> queryAll() {
        example.setOrderByClause("id asc,state desc");
        List<SysUserDTO> users = sysUserMapper.selectUserInfoByExample(example);
        example.clear();
        return users;
    }

    @Override
    public int updatePasswordById(Long id, String md5PasswordWithSalt) {
        SysUser user = new SysUser();
        user.setId(id);
        user.setPassword(md5PasswordWithSalt);
        return sysUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int updateUserInfo(SysUser user) {
        user.setEmail(RSAUtils.encrypt(user.getEmail()));
        return sysUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public SysUser findById(Long id) {
        SysUser user = sysUserMapper.selectByPrimaryKey(id);
        user.setEmail(RSAUtils.decrypt(user.getEmail()));
        return user;
    }

}
