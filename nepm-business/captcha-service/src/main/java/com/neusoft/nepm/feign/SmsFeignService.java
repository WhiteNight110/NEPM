package com.neusoft.nepm.feign;

import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.common.po.Mail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("mq")
public interface SmsFeignService {

    /**
     * 邮件发送
     * @param mail
     * @return CommonResult<Boolean>
     */
    @RequestMapping("/mq/mail")
    public CommonResult<Boolean> sendMail(@RequestBody Mail mail);

    /**
     * 短信发送
     * @param phone
     * @return CommonResult<Boolean>
     */
    @RequestMapping("/mq/sms")
    public CommonResult<Boolean> sendVerifyCode(@RequestParam String phone);

    /**
     * 短信确认
     * @param phone
     * @param code
     * @return CommonResult<Boolean>
     */
    @RequestMapping("/mq/checkSms")
    public CommonResult<Boolean> checkSms(@RequestParam String phone, @RequestParam String code);

}
