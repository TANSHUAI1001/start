package com.tan.start.service.impl;

import com.tan.start.dao.FundDataMapper;
import com.tan.start.entity.FundData;
import com.tan.start.entity.FundDataExample;
import com.tan.start.service.FundDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FundDataServiceImpl implements FundDataService {

    @Resource
    private FundDataMapper fundDataMapper;

    private FundDataExample example = new FundDataExample();

    @Override
    public List<FundData> queryAll() {
        example.setOrderByClause("fund_data.market asc, fund_data.ts_code asc");
        return fundDataMapper.selectByExampleWithBLOBs(example);
    }
}
