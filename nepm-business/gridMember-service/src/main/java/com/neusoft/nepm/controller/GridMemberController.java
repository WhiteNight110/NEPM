package com.neusoft.nepm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.common.po.GridMember;
import com.neusoft.nepm.service.GridMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "GridMemberController", description = "区域网格员信息")
@RequestMapping("/gridMember")
public class GridMemberController {

    @Autowired
    private GridMemberService gridMemberService;

    @ResponseBody
    @GetMapping("/listGridMemberByProvinceId")
    public CommonResult<List<GridMember>> listGridMemberByProvinceId(@RequestParam Integer provinceId){
        QueryWrapper<GridMember> qw = new QueryWrapper<>();
        qw.eq("province_id", provinceId);
        List<GridMember> gridMembers = gridMemberService.list(qw);
        return CommonResult.success(gridMembers);
    }

    @ResponseBody
    @GetMapping("/listGridMemberByCityId")
    public CommonResult<List<GridMember>> listGridMemberByCityId(@RequestParam Integer cityId){
        QueryWrapper<GridMember> qw = new QueryWrapper<>();
        qw.eq("city_id", cityId);
        List<GridMember> gridMembers = gridMemberService.list(qw);
        return CommonResult.success(gridMembers);
    }

    @ResponseBody
    @PostMapping("/getGridMemberByCodeByPass")
    public CommonResult<Integer> getGridMemberByCodeByPass(@RequestBody GridMember gridMember){
        String msg = gridMemberService.gridMemberLogin(gridMember);
        if(("FAILED").equals(msg)){
            return CommonResult.failed("用户名或密码有误");
        }
        else{
            return CommonResult.success(gridMemberService.getGridMemberId(gridMember), msg);
        }
    }

    @ApiOperation("网格员注册")
    @PostMapping("/gridMemberRegister")
    @ResponseBody
    public CommonResult<String> gmRegister(@RequestBody GridMember gridMember){
        String msg = gridMemberService.gmRegister(gridMember);
        if(("FAILED").equals(msg)){
            return CommonResult.failed("用户已存在");
        }
        else{
            return CommonResult.success("注册成功");
        }
    }


}
