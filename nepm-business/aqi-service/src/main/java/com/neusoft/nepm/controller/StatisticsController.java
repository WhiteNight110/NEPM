package com.neusoft.nepm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.neusoft.nepm.common.api.CommonPage;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.common.dto.CountResponseDto;
import com.neusoft.nepm.common.dto.StatisticsPageRequestDto;
import com.neusoft.nepm.common.dto.StatisticsPageResponseDto;
import com.neusoft.nepm.common.po.AqiFeedback;
import com.neusoft.nepm.common.po.Statistics;
import com.neusoft.nepm.service.AqiFeedbackService;
import com.neusoft.nepm.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "StatisticsController", description = "Statistics模块")
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private AqiFeedbackService aqiFeedbackService;

    /**
     * 保存网格员提交的Aqi确认信息
     * @param statistics
     * @return CommonResult<Boolean>
     */
    @ApiOperation("保存网格员提交的Aqi确认信息")
    @PutMapping("/save")
    public CommonResult<Boolean> saveStatistics(@ApiParam("待上传检测数据") @RequestBody Statistics statistics){
        return CommonResult.success(statisticsService.save(statistics));
    }

    /**
     * 查询待确认Aqi信息列表，并有模糊查询和分页功能
     * @param staPageRequestDto
     * @return CommonResult<CommonPage<StatisticsPageResponseDto>>
     */
    @ApiOperation("查询待确认Aqi信息列表，并有模糊查询和分页功能")
    @ResponseBody
    @PostMapping("/list")
    public CommonResult<CommonPage<StatisticsPageResponseDto>> listStatisticsPage(@ApiParam("待确认Aqi信息列表分页参数") @RequestBody StatisticsPageRequestDto staPageRequestDto){

        return CommonResult.success(statisticsService.listStatistics(staPageRequestDto));
    }

    /**
     * 根据主键查询确认Statistics信息
     * @param id
     * @return CommonResult<Statistics>
     */
    @ApiOperation("根据主键查询确认Statistics信息")
    @GetMapping("/{id}")
    public CommonResult<Statistics> getStatisticsById(@PathVariable("id") int id){
        return CommonResult.success(statisticsService.getById(id));
    }

    /**
     * 查询省分组AQI超标累计信息
     * @return CommonResult<List<Map<String, Object>>>
     */
    @ApiOperation("查询省分组AQI超标累计信息")
    @GetMapping("/listProvinceItemTotalStatis")
    public CommonResult<List<Map<String, Object>>> listProvinceItemTotalStatis(){
        List<Map<String, Object>> result = statisticsService.getStatisticsWithProvinceDetails();
        return CommonResult.success(result);
    }

    /**
     * 查询反馈数据总数
     * @return CommonResult<CountResponseDto>
     */
    @ApiOperation("查询反馈数据总数")
    @GetMapping("/totalCount")
    public CommonResult<CountResponseDto> totalCount(){
        // 创建一个CountResponseDto对象用于存储统计结果
        CountResponseDto countResponseDto = new CountResponseDto();

        // 设置统计的总数量
        countResponseDto.setTotalCount(statisticsService.count());

        // 创建查询条件，筛选出aqi_level小于等于1的记录
        QueryWrapper<Statistics> qw = new QueryWrapper<>();
        qw.le("aqi_level", 1);

        // 设置满足条件的记录数量
        countResponseDto.setGoodCount(statisticsService.count(qw));

        // 返回包含统计结果的CommonResult对象
        return CommonResult.success(countResponseDto);

    }

    /**
     * AQI指数等级分布统计
     * @return CommonResult<List<Map<Integer, Integer>>>
     */
    @ApiOperation("AQI指数等级分布统计")
    @GetMapping("/aqiDistribution")
    public CommonResult<List<Map<Integer, Integer>>> aqiDistribution(){
        List<Map<Integer, Integer>> result = statisticsService.getAqiDistribution();
        return CommonResult.success(result);
    }

    /**
     * AQI指数等级分布统计
     * @return CommonResult<List<Map<Integer, Integer>>>
     */
    @ApiOperation("AQI指数等级分布统计")
    @ResponseBody
    @GetMapping("/so2Distribution")
    public CommonResult<List<Map<Integer, Integer>>> so2Distribution(){
        List<Map<Integer, Integer>> result = statisticsService.getSo2Distribution();
        return CommonResult.success(result);
    }

    /**
     * AQI指数等级分布统计
     * @return CommonResult<List<Map<Integer, Integer>>>
     */
    @ApiOperation("AQI指数等级分布统计")
    @GetMapping("/coDistribution")
    public CommonResult<List<Map<Integer, Integer>>> coDistribution(){
        List<Map<Integer, Integer>> result = statisticsService.getCoDistribution();
        return CommonResult.success(result);
    }

    /**
     * AQI指数等级分布统计
     * @return CommonResult<List<Map<Integer, Integer>>>
     */
    @ApiOperation("AQI指数等级分布统计")
    @GetMapping("/spmDistribution")
    public CommonResult<List<Map<Integer, Integer>>> spmDistribution(){
        List<Map<Integer, Integer>> result = statisticsService.getSpmDistribution();
        return CommonResult.success(result);
    }

    /**
     * 查询近12个月空气质量指数
     * @return CommonResult<List<Map<String, Integer>>>
     */
    @ApiOperation("查询近12个月空气质量指数")
    @GetMapping("/aqiLevelByMonth")
    public CommonResult<List<Map<String, Integer>>> aqiLevelByMonth(){
        List<Map<String, Integer>> monthlyCounts = statisticsService.getAqiLevelByMonth();
        return CommonResult.success(monthlyCounts);
    }

    /**
     * Aqi反馈信息确认
     * @param afId
     * @return CommonResult<Boolean>
     */
    @ApiOperation("Aqi反馈信息确认")
    @PutMapping("/confirmAqiFeedback/{afId}")
    public CommonResult<Boolean> confirmAqiFeedback(@PathVariable Integer afId){
        // 创建一个UpdateWrapper对象，用于构建更新条件
        UpdateWrapper<AqiFeedback> uw = new UpdateWrapper<>();
        uw.eq("af_id", afId);
        uw.set("state", 2);

        // 使用aqiFeedbackService执行更新操作，并返回更新结果
        Boolean result = aqiFeedbackService.update(uw);

        return CommonResult.success(result);
    }
}
