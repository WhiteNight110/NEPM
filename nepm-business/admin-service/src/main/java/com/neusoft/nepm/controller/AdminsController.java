package com.neusoft.nepm.controller;

import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.common.api.ValidateCodeVo;
import com.neusoft.nepm.common.po.Admins;
import com.neusoft.nepm.feign.CaptchaFeignService;
import com.neusoft.nepm.service.AdminsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@Api(tags = "AdminController", description = "管理员端")
@RequestMapping("/admins")
public class AdminsController {

    @Autowired
    private AdminsService adminsService;

    @Autowired
    private CaptchaFeignService captchaFeignService;

    //验证码生效时间限制
    private static final long VALID_MILLIS_TIME = 60 * 1000;

    @ApiOperation("根据管理员编码和密码进行查询，用于登录")
    @PostMapping("/getAdminsByCode")
    @ResponseBody
    public CommonResult<String> getAdminsByCode(@RequestBody Admins admins){

        String msg = adminsService.adminsLogin(admins);
        if(("FAILED").equals(msg)){
            return CommonResult.failed("用户名或密码有误");
        }
        else{
            return CommonResult.successWithString(msg);
        }
    }

    @ApiOperation("管理员注册")
    @PostMapping("/adminsRegister")
    @ResponseBody
    public CommonResult<String> adminRegister(@RequestBody Admins admins){
        String msg = adminsService.adminRegister(admins);
        if(("FAILED").equals(msg)){
            return CommonResult.failed("用户已存在");
        }
        else{
            return CommonResult.success("注册成功");
        }
    }

    @ApiOperation("获取验证码")
    @GetMapping("/getCaptcha")
    @ResponseBody
    public ValidateCodeVo getCaptcha(){
        return captchaFeignService.getCaptcha();
    }

    @ApiOperation("校验验证码")
    @PostMapping("/checkCaptcha")
    public boolean checkCaptcha(@RequestParam("captcha") String captcha, @RequestParam("codeKey") String codeKey) {
        return captchaFeignService.checkCaptcha(captcha, codeKey);
    }



}
