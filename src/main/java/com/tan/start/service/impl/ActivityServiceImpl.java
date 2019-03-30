package com.tan.start.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tan.start.dao.ActivityMapper;
import com.tan.start.entity.Activity;
import com.tan.start.entity.ActivityExample;
import com.tan.start.service.ActivityService;

@Service
@CacheConfig(cacheNames = "activity")
public class ActivityServiceImpl implements ActivityService{

	@Resource
	private ActivityMapper activityMapper;
	
	@Override
	public List<Activity> queryActivities() {
		ActivityExample activityExample = new ActivityExample();
		activityExample.createCriteria().andActivityIdBetween(1000L, 1008L);
		
		return activityMapper.selectByExample(activityExample);
	}

	@Override
	@Cacheable(key ="#p0")
	public Activity findById(Long id) {
		return activityMapper.selectByPrimaryKey(id);
	}

}
