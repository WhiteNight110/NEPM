package com.neusoft.nepm.controller;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.po.GridCity;
import com.neusoft.nepm.po.GridMember;
import com.neusoft.nepm.service.GridCityService;
import com.neusoft.nepm.service.GridMemberService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @GetMapping("/getGridMemberByCodeByPass")
    public CommonResult<String> getGridMemberByCodeByPass(@RequestParam String gmCode,@RequestParam String password){
        GridMember gridMember = new GridMember();
        gridMember.setGmCode(gmCode);
        gridMember.setPassword(password);

        String msg = gridMemberService.gridMemberLogin(gridMember);
        if(("SUCCESS").equals(msg)){
            return CommonResult.success("登录成功");
        }
        else{
            return CommonResult.fail("用户名或密码有误");
        }
    }


}
