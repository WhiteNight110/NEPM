package com.neusoft.nepm.controller;

import com.neusoft.nepm.common.api.CommonPage;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.po.Admins;
import com.neusoft.nepm.po.AqiFeedback;
import com.neusoft.nepm.service.AdminsService;
import com.neusoft.nepm.service.impl.AdminsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = "AdminController", description = "管理员端")
@RequestMapping("/admins")
public class AdminsController {
    @Autowired
    private AdminsService adminsService;

    @ApiOperation("根据管理员编码和密码进行查询，用于登录")
    @PostMapping("/getAdminsByCode")
    @ResponseBody
    public CommonResult<String> getAdminsByCode(@RequestBody Admins admins){

        String msg = adminsService.adminsLogin(admins);
        if(("SUCCESS").equals(msg)){
            return CommonResult.success("登录成功");
        }
        else{
            return CommonResult.fail("用户名或密码有误");
        }
    }

    @ApiOperation("管理员注册")
    @PostMapping("/adminRegister")
    public CommonResult<String> adminRegister(@RequestBody Admins admins){
        String msg = adminsService.adminsLogin(admins);
        if(("SUCCESS").equals(msg)){
            return CommonResult.success("注册成功");
        }
        else{
            return CommonResult.fail("用户已存在");
        }
    }




}
