package com.neusoft.nepm.controller;

import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.common.api.ValidateCodeVo;
import com.neusoft.nepm.common.po.Admins;
import com.neusoft.nepm.feign.CaptchaFeignService;
import com.neusoft.nepm.service.AdminsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@Api(tags = "AdminController", description = "管理员模块")
@RequestMapping("/admins")
public class AdminsController {

    @Autowired
    private AdminsService adminsService;

    @Autowired
    private CaptchaFeignService captchaFeignService;

    //验证码生效时间限制
    private static final long VALID_MILLIS_TIME = 60 * 1000;

    /**
     * 根据管理员编码和密码进行查询，用于登录
     * @param adminCode
     * @param password
     * @return CommonResult<String>登陆成功授权token
     */
    @ApiOperation("根据管理员编码和密码进行查询，用于登录")
    @GetMapping("/login/{adminCode}/{password}")
    public CommonResult<String> getAdminsByCode(@ApiParam(name = "登陆账号") @PathVariable("adminCode") String adminCode,
                                                @ApiParam(name = "登陆密码") @PathVariable("password") String password){
        //创建Admins对象
        Admins admins = new Admins();
        admins.setAdminCode(adminCode);
        admins.setPassword(password);

        String msg = adminsService.adminsLogin(admins);

        if(("FAILED").equals(msg)){
            return CommonResult.failed("用户名或密码有误");
        }
        return CommonResult.successWithString(msg);
    }

    /**
     * 管理员注册
     * @param admins
     * @return CommonResult<String> 创建结果信息
     */
    @ApiOperation("管理员注册")
    @PutMapping("/register")
    @ResponseBody
    public CommonResult<String> adminRegister(@ApiParam(name ="待注册用户") @RequestBody Admins admins){
        String msg = adminsService.adminRegister(admins);
        if(("FAILED").equals(msg)){
            return CommonResult.failed("用户已存在");
        }
        return CommonResult.success("注册成功");

    }

    /**
     * 获取验证码
      * @return 验证码封装类
     */
    @ApiOperation("获取验证码")
    @GetMapping("/captcha")
    public CommonResult<ValidateCodeVo> getCaptcha(){
        return captchaFeignService.getCaptcha();
    }

    /**
     * 校验验证码
     * @param captcha
     * @param codeKey
     * @return 验证码校验结果
     */
    @ApiOperation("校验验证码")
    @GetMapping("/captcha/{captcha}/{codeKey}")
    public CommonResult<Boolean> checkCaptcha(@PathVariable("captcha") String captcha,
                                              @PathVariable("codeKey") String codeKey) {
        return captchaFeignService.checkCaptcha(captcha, codeKey);
    }



}
