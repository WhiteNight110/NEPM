package com.neusoft.nepm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.common.po.GridMember;
import com.neusoft.nepm.common.po.GridProvince;
import com.neusoft.nepm.service.GridProvinceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "GridProvinceController", description = "GridProvince模块")
@RequestMapping("/gridProvince")
public class GridProvinceController {

    @Autowired
    private GridProvinceService gridProvinceService;

    /**
     * 查询指定网格员所在省份
     * @param gridMember
     * @return CommonResult<GridProvince>
     */
    @ApiOperation("查询指定网格员所在省份")
    @GetMapping("/getGridProvinceByGridMember")
    public CommonResult<GridProvince> getGridProvinceByGridMember(@RequestBody GridMember gridMember){
        // 创建QueryWrapper对象，用于构建查询条件
        QueryWrapper<GridProvince> qw = new QueryWrapper<>();

        // 添加查询条件
        qw.eq("province_id", gridMember.getProvinceId());

        // 使用gridProvince根据查询条件获取网格成员列表
        GridProvince gridProvince = gridProvinceService.getOne(qw);

        // 返回包含网格成员列表的通用结果
        return CommonResult.success(gridProvince);
    }

}
