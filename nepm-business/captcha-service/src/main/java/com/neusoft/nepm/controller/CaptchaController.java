package com.neusoft.nepm.controller;

import com.aliyun.teautil.Common;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.common.api.ValidateCodeVo;
import com.neusoft.nepm.service.CaptchaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@Api(tags = "CaptchaController", description = "验证码验证")
@RequestMapping("/captcha")

public class CaptchaController {

    @Autowired
    private CaptchaService captchaService;

    /**
     * 获取验证码
     * @return CommonResult<ValidateCodeVo>
     */
    @ApiOperation("获取验证码")
    @GetMapping("/getCaptcha")
    @ResponseBody
    public CommonResult<ValidateCodeVo> getCaptcha(){
        return CommonResult.success(captchaService.generateValidateCode()) ;
    }

    /**
     * 校验验证码
     * @param captcha
     * @param codeKey
     * @return CommonResult<Boolean
     */
    @ApiOperation("校验验证码")
    @GetMapping("/{captcha}/{codeKey}")
    public CommonResult<Boolean> checkCaptcha(@ApiParam("待校验验证码") @PathVariable("captcha") String captcha,
                                              @ApiParam("redis中存储的验证码key") @PathVariable("codeKey") String codeKey) {
        return CommonResult.success(captchaService.verifyValidateCode(captcha, codeKey));
    }
}
