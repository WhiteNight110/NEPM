package com.neusoft.nepm.controller;

import com.aliyun.teautil.Common;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.nepm.common.api.CommonPage;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.dto.CountResponseDto;
import com.neusoft.nepm.dto.StatisticsPageRequestDto;
import com.neusoft.nepm.dto.StatisticsPageResponseDto;
import com.neusoft.nepm.po.Statistics;
import com.neusoft.nepm.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "StatisticsController", description = "统计上传数据")
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @ApiOperation("保存网格员提交的AQI确认信息")
    @ResponseBody
    @PostMapping("/saveStatistics")
    public CommonResult<Boolean> saveStatistics(@RequestBody Statistics statistics){
        System.out.println("=======test=======");
        System.out.println(statistics);
        return CommonResult.success(statisticsService.save(statistics));
    }

    @ApiOperation("查询确认AQI信息列表，并有模糊查询和分页功能")
    @ResponseBody
    @PostMapping("/listStatisticsPage")
    public CommonResult<CommonPage<StatisticsPageResponseDto>> listStatisticsPage(@RequestBody StatisticsPageRequestDto staPageRequestDto){

        return CommonResult.success(statisticsService.listStatistics(staPageRequestDto));
    }

    @ApiOperation("根据主键查询确认Statistics信息")
    @ResponseBody
    @GetMapping("/getStatisticsById")
    public CommonResult<Statistics> getStatisticsById(@RequestParam int id){
        return CommonResult.success(statisticsService.getById(id));
    }

    @ApiOperation("查询省分组AQI超标累计信息")
    @ResponseBody
    @GetMapping("/listProvinceItemTotalStatis")
    public CommonResult<List<Map<String, Object>>> listProvinceItemTotalStatis(){
        List<Map<String, Object>> result = statisticsService.getStatisticsWithProvinceDetails();
        return CommonResult.success(result);
    }

    @ApiOperation("查询反馈数据总数")
    @ResponseBody
    @GetMapping("/totalCount")
    public CommonResult<CountResponseDto> totalCount(){
        CountResponseDto countResponseDto = new CountResponseDto();
        countResponseDto.setTotalCount(statisticsService.count());

        QueryWrapper<Statistics> qw = new QueryWrapper<>();
        qw.le("aqi_level", 1);
        countResponseDto.setGoodCount(statisticsService.count(qw));

        return CommonResult.success(countResponseDto);
    }

    @ApiOperation("AQI指数等级分布统计\n")
    @ResponseBody
    @GetMapping("/statisticsDistribution")
    public CommonResult<List<Map<Integer, Integer>>> statisticsDistribution(){
        List<Map<Integer, Integer>> result = statisticsService.getStatisticsDistribution();
        return CommonResult.success(result);
    }

    @ApiOperation("查询近12个月空气质量指数")
    @ResponseBody
    @GetMapping("/aqiLevelByMonth")
    public CommonResult<List<Map<String, Integer>>> aqiLevelByMonth(){
        List<Map<String, Integer>> monthlyCounts = statisticsService.getAqiLevelByMonth();
        return CommonResult.success(monthlyCounts);
    }



}
