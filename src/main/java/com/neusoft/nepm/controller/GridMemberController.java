package com.neusoft.nepm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.po.GridMember;
import com.neusoft.nepm.service.GridMemberService;
import io.swagger.annotations.Api;
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
    public CommonResult<List<GridMember>> listGridMemberByProvinceId(@RequestParam int provinceId){
        QueryWrapper<GridMember> qw = new QueryWrapper<>();
        qw.eq("province_id", provinceId);
        List<GridMember> gridMembers = gridMemberService.list(qw);
        return CommonResult.success(gridMembers);
    }

    @ResponseBody
    @PostMapping("/getGridMemberByCodeByPass")
    public CommonResult<String> getGridMemberByCodeByPass(@RequestBody GridMember gridMember){
        String msg = gridMemberService.gridMemberLogin(gridMember);
        if(("SUCCESS").equals(msg)){
            return CommonResult.success("登录成功");
        }
        else{
            return CommonResult.fail("用户名或密码有误");
        }
    }


}
