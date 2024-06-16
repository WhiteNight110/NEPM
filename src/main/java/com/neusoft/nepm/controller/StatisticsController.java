package com.neusoft.nepm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.nepm.common.api.CommonPage;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.dto.StatisticsPageRequestDto;
import com.neusoft.nepm.po.Statistics;
import com.neusoft.nepm.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = "StatisticsController", description = "统计上传数据")
@RequestMapping("/Statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @ApiOperation("保存网格员提交的AQI确认信息")
    @ResponseBody
    @PostMapping("/saveStatistics")
    public CommonResult<Boolean> saveStatistics(Statistics statistics){
        return CommonResult.success(statisticsService.save(statistics));
    }

    @ApiOperation("查询确认AQI信息列表，并有模糊查询和分页功能")
    @ResponseBody
    @GetMapping("/listStatisticsPage")
    public CommonResult<CommonPage<Statistics>> listStatisticsPage(@RequestBody StatisticsPageRequestDto staPageRequestDto){
        QueryWrapper<Statistics> qw = new QueryWrapper<>();
        if(staPageRequestDto.getAqiLevel() != 0){
            qw.eq("aqi_level", staPageRequestDto.getAqiLevel());
        }
        if(staPageRequestDto.getProvince_id() != 0){
            qw.eq("province_id", staPageRequestDto.getProvince_id());
        }
        if(staPageRequestDto.getSo2Level() != 0){
            qw.eq("so2_level", staPageRequestDto.getSo2Level());
        }
        if(staPageRequestDto.getCoLevel() != 0){
            qw.eq("co_level", staPageRequestDto.getCoLevel());
        }
        if(staPageRequestDto.getSpmLevel() != 0){
            qw.eq("spm_level", staPageRequestDto.getSpmLevel());
        }
        if(staPageRequestDto.getAddress() != "" && staPageRequestDto.getAddress() != null){
            qw.like("address", staPageRequestDto.getAddress());
        }
        Page<Statistics> statisticsPage = new Page<>(staPageRequestDto.getPage(), staPageRequestDto.getSize());

        return CommonResult.success(CommonPage.restPage(statisticsService.page(statisticsPage, qw)));
    }


}
