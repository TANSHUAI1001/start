package com.tan.start.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tan.start.entity.Activity;
import com.tan.start.service.ActivityService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value="/activity")
public class ActivityController {
    @Resource
    private ActivityService activityService;

    private Logger logger = LoggerFactory.getLogger(ActivityController.class);

    @RequestMapping(value="/find/{id}")
    @ResponseBody
    public Activity findByID(@PathVariable("id") Long id) {
        return activityService.findById(id);
    }

    @RequestMapping(value="/data")
    @ResponseBody
    public List<Activity> data(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("name","shuai");
        logger.debug("sessionNew ?  "+session.isNew());
        return activityService.queryActivities();
    }

    // ResponseEntity不仅可以返回json结果，还可以定义返回的HttpHeaders和HttpStatus
    @RequestMapping(value="/page")
    @ResponseBody
    public ResponseEntity page() {
        PageHelper.startPage(1,3);
        List<Activity> list = activityService.queryActivities();
        PageInfo<Activity> info = new PageInfo<Activity>(list);
        logger.info("size: "+info.getSize());
        return ResponseEntity.ok(info);

    }
}
