package com.tan.start.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tan.start.entity.FundData;
import com.tan.start.service.FundDataService;
import com.tan.start.utils.ResponseResult;
import com.tan.start.utils.datatable.PageParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class FundController {

    @Resource
    private FundDataService fundService;

    @RequestMapping("/api/fund")
    public ResponseResult getResource(PageParam pageParam){
        PageHelper.offsetPage(pageParam.getStart(),pageParam.getLength());
        List<FundData> fundDataList = fundService.queryAll();
        long total = ((Page) fundDataList).getTotal();
        return ResponseResult.ok().put("data",fundDataList).
                put("draw",pageParam.getDraw()).
                put("start",pageParam.getStart()).
                put("length",pageParam.getLength()).
                put("recordsTotal",total).
                put("recordsFiltered",total);
    }
}
