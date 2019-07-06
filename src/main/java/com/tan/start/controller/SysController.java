package com.tan.start.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tan.start.entity.SysResource;
import com.tan.start.entity.SysUser;
import com.tan.start.service.SysResourceService;
import com.tan.start.service.SysUserService;
import com.tan.start.utils.datatable.PageParam;
import com.tan.start.utils.ResponseResult;
import com.tan.start.view.BaseVO;
import com.tan.start.view.SysUserVO;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequiresRoles("admin")
@RequestMapping("/sys")
public class SysController {

    private Logger logger = LoggerFactory.getLogger(SysController.class);

    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysResourceService sysResourceService;

    @RequestMapping("/user")
    public ResponseResult getUser(){
        PageHelper.startPage(1,10);
        List<SysUser> sysUsers = sysUserService.queryAll();
        List<SysUserVO> users = BaseVO.convertList(sysUsers,SysUserVO.class);
        logger.debug("total:{},pages:{}",((Page) sysUsers).getTotal(),((Page) sysUsers).getPages());
        return ResponseResult.ok().put("data",users);
    }

    @RequestMapping("/resource")
    public ResponseResult getResource(PageParam pageParam){
        PageHelper.startPage(1,3);
//        PageHelper.offsetPage(start,length);
        List<SysResource> resources = sysResourceService.queryAll();
        long total = ((Page) resources).getTotal();
        logger.info("total:{}",total);
        return ResponseResult.ok().put("data",resources).
                put("draw",pageParam.getDraw()).put("start",pageParam.getStart()).put("length",pageParam.getLength()).
                put("recordsTotal",total*10).put("recordsFiltered",total*10);
    }
}
