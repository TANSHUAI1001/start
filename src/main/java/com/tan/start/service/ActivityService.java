package com.tan.start.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.tan.start.entity.Activity;

public interface ActivityService {

    public List<Activity> queryActivities();

    public Activity findById(Long id);

}
