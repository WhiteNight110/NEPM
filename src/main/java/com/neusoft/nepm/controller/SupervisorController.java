package com.neusoft.nepm.controller;

import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.common.api.ResultCode;
import com.neusoft.nepm.po.Supervisor;
import com.neusoft.nepm.service.SupervisorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = "SupervisorController", description = "决策者")
@RequestMapping("/supervisor")
public class SupervisorController {
    @Autowired
    private SupervisorService supervisorService;

    @ApiOperation("根据主键查询公众监督员，用于注册时手机号码是否存在验证")
    @ResponseBody
    @GetMapping("/getSupervisorById")
    public CommonResult<Supervisor> getSupervisorById(@RequestParam int telId){
        return CommonResult.success(supervisorService.getById(telId));
    }

    @ApiOperation("保存公众监督员信息，用于注册")
    @ResponseBody
    @PostMapping("/saveSupervisor")
    public CommonResult<String> saveSupervisor(@RequestBody Supervisor supervisor){
        String msg = supervisorService.supervisorRegister(supervisor);
        if(("SUCCESS").equals(msg)){
            return CommonResult.success("注册成功");
        }else{
            return CommonResult.failed("用户名已注册");
        }
    }

    @ApiOperation("根据公众监督员手机号码和密码查询，用于登录。")
    @ResponseBody
    @PostMapping("/getSupervisorByIdByPass")
    public CommonResult<String> getSupervisorByIdByPass(@RequestBody Supervisor supervisor){
        String msg = supervisorService.supervisorLogin(supervisor);
        if(("FAILED").equals(msg)){
            return CommonResult.failed("用户名或密码有误");
        }
        else{
            return CommonResult.successWithString(msg);
        }
    }


}
