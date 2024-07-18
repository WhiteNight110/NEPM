package com.neusoft.nepm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neusoft.nepm.service.GridCityService;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.common.po.GridCity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "GridCityController", description = "GridCity模块")
@RequestMapping("/gridCity")
public class GridCityController {

    @Autowired
    private GridCityService gridCityService;

    /**
     * 根据省份查询包含城市
     * @param provinceId
     * @return CommonResult<List<GridCity>>
     */
    @ApiOperation("根据省份查询包含城市")
    @GetMapping("/{provinceId}")
    public CommonResult<List<GridCity>> listGridCityByProvinceId(@PathVariable("provinceId") Integer provinceId){
        // 创建一个查询包装器，指定查询条件为province_id等于传入的省份ID
        QueryWrapper<GridCity> qw = new QueryWrapper<>();
        qw.eq("province_id", provinceId);

        // 根据查询条件从服务中获取城市列表
        List<GridCity> aqiFeedbackList = gridCityService.list(qw);

        // 返回包含城市列表的成功结果
        return CommonResult.success(aqiFeedbackList);
    }
}
