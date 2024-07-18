package com.nepm.neusoft.nepm.mq.controller;


import com.nepm.neusoft.nepm.mq.service.SmsService;
import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.common.po.Mail;
import com.nepm.neusoft.nepm.mq.service.ProduceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "MQController", description = "MQ模块")
@RestController
@RequestMapping("/mq")
public class MQController {

    @Autowired
    private ProduceService produceService;

    @Autowired
    private SmsService smsService;

    /**
     * 发送邮件
     * @param mail
     * @return CommonResult<Boolean>
     */
    @ApiOperation("发送邮件")
    @PostMapping("/mail")
    public CommonResult<Boolean> sendMail(@ApiParam("待发送邮件") @RequestBody Mail mail) {
        return CommonResult.success(produceService.send(mail));
    }

    /**
     * 发送短信验证码
     * @param phone
     * @return CommonResult<Boolean>
     */
    @ApiOperation("发送短信验证码")
    @PostMapping("/sms/{phone}")
    public CommonResult<Boolean> sendVerifyCode(@ApiParam("手机号") @PathVariable("phone") String phone){
        Boolean aBoolean = this.smsService.sendVerifyCode(phone);
        if (!aBoolean){
            return CommonResult.failed();
        }
        return CommonResult.success(true);
    }

    /**
     * 校验短信验证码
     * @param phone
     * @param code
     * @return CommonResult<Boolean
     */
    @ApiOperation("校验短信验证码")
    @GetMapping("/sms/{phone}/{code}")
    public CommonResult<Boolean> checkSms(@ApiParam("手机号码") @PathVariable("phone") String phone,
                                          @ApiParam("验证码") @PathVariable("code") String code) {
        return CommonResult.success(smsService.verifySms(phone, code));
    }



    }
