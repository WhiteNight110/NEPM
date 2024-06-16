package com.neusoft.nepm.controller;

import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.po.Aqi;
import com.neusoft.nepm.service.AqiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(tags = "AqiController", description = "AQI查询")
@RequestMapping("/aqi")
public class AqiController {
    @Autowired
    private AqiService aqiService;

    @ApiOperation("全查询AQI信息")
    @ResponseBody
    @GetMapping("/listAqiAll")
    public CommonResult<List<Aqi>> listAqiAll(){
        List<Aqi> aqiList = aqiService.AqiByAll();
        return CommonResult.success(aqiList);
    }

}
