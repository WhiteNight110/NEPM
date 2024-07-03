package com.neusoft.nepm.controller;

import com.neusoft.nepm.common.api.ValidateCodeVo;
import com.neusoft.nepm.service.CaptchaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@Api(tags = "CaptchaController", description = "验证码验证")
@RequestMapping("/captcha")

public class CaptchaController {
    @Autowired
    private CaptchaService captchaService;


    @ApiOperation("获取验证码")
    @GetMapping("/getCaptcha")
    @ResponseBody
    public ValidateCodeVo getCaptcha(){
        return captchaService.generateValidateCode();
    }

    @ApiOperation("校验验证码")
    @PostMapping("/checkCaptcha")
    public boolean checkCaptcha(@RequestParam String captcha, @RequestParam String codeKey) {
        return captchaService.verifyValidateCode(captcha, codeKey);
    }

}
