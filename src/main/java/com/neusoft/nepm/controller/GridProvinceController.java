package com.neusoft.nepm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.po.GridMember;
import com.neusoft.nepm.po.GridProvince;
import com.neusoft.nepm.service.GridProvinceService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = "GridProvinceController", description = "网格省级信息")
@RequestMapping("/gridProvinceController")
public class GridProvinceController {
    @Autowired
    private GridProvinceService gridProvinceService;

    @ResponseBody
    @GetMapping("/getGridProvinceByGridMember")
    public CommonResult<GridProvince> getGridProvinceByGridMember(@RequestBody GridMember gridMember){
        QueryWrapper<GridProvince> qw = new QueryWrapper<>();
        qw.eq("province_id", gridMember.getProvinceId());
        GridProvince gridProvince = gridProvinceService.getOne(qw);

        return CommonResult.success(gridProvince);
    }
}
