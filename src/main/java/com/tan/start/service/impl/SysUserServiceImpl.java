package com.tan.start.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tan.start.dao.SysUserMapper;
import com.tan.start.entity.SysUser;
import com.tan.start.entity.SysUserExample;
import com.tan.start.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService{
	
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser findByName(String name) {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsernameEqualTo(name).andStateEqualTo(1);
		
		return sysUserMapper.selectByExample(example).get(0);
	}

}
