package com.neusoft.nepm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.po.AqiFeedback;
import com.neusoft.nepm.po.GridCity;
import com.neusoft.nepm.service.GridCityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(tags = "GridCityController", description = "系统网格覆盖市区域")
@RequestMapping("/gridCity")
public class GridCityController {

    @Autowired
    private GridCityService gridCityService;

    @ResponseBody
    @GetMapping("/listGridCityByProvinceId")
    public CommonResult<List<GridCity>> listGridCityByProvinceId(@RequestParam int provinceId){
        QueryWrapper<GridCity> qw = new QueryWrapper<>();
        qw.eq("province_id", provinceId);
        List<GridCity> aqiFeedbackList = gridCityService.list(qw);
        return CommonResult.success(aqiFeedbackList);
    }


}
