package com.tan.start.service.impl;

import com.tan.start.dao.SysResourceMapper;
import com.tan.start.entity.SysResource;
import com.tan.start.entity.SysResourceExample;
import com.tan.start.service.SysResourcesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysResourcesServiceImpl implements SysResourcesService {

    @Resource
    private SysResourceMapper sysResourcesMapper;

    @Override
    public List<SysResource> getMenu() {
        SysResourceExample example = new SysResourceExample();
        example.createCriteria().andTypeEqualTo("menu").andStateEqualTo(1);
        return sysResourcesMapper.selectByExample(example);
    }
}
