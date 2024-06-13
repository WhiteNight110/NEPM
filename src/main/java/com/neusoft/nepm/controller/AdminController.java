package com.neusoft.nepm.controller;

import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.mbg.model.Admins;
import com.neusoft.nepm.service.AdminsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "AdminController", description = "管理员端")
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminsService adminsService;

    /**
     * 根据管理员编码和密码进行查询，用于登录
     * @param admins
     * @return String
     */
    @ApiOperation("根据管理员编码和密码进行查询，用于登录")
    @GetMapping("/getAdminsByCode")
    @ResponseBody
    public CommonResult<String> getAdminsByCode(@ApiParam("待登录管理员用户") Admins admins){

        String msg = adminsService.getAdminsByCode(admins);
        if(("SUCCESS").equals(msg)){
            return CommonResult.success("登录成功");
        }
        else{
            return CommonResult.failed("用户名或密码有误");
        }
    }
}
