package com.neusoft.nepm.controller;

import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.common.po.Aqi;
import com.neusoft.nepm.service.AqiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Api(tags = "AqiController", description = "AQI模块")
@RequestMapping("/aqi")
public class AqiController {
    @Autowired
    private AqiService aqiService;

    /**
     * 查询所有Aqi信息
     * @return
     */
    @ApiOperation("全查询AQI信息")
    @GetMapping("/all")
    public CommonResult<List<Aqi>> listAqiAll(){
        List<Aqi> aqiList = aqiService.AqiByAll();
        return CommonResult.success(aqiList);
    }

}
