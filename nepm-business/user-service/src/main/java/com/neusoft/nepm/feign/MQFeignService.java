package com.neusoft.nepm.feign;

import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.common.po.Mail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("mq")
public interface MQFeignService {
    /**
     * 短信发送
     * @param phone
     * @return CommonResult<Boolean>
     */
    @RequestMapping(method = RequestMethod.POST, value = "/mq/sms/{phone}")
    public CommonResult<Boolean> sendVerifyCode(@PathVariable("phone") String phone);

    /**
     * 短信确认
     * @param phone
     * @param code
     * @return CommonResult<Boolean>
     */
    @RequestMapping("/mq/sms/{phone}/{code}")
    public CommonResult<Boolean> checkSms(@PathVariable("phone") String phone, @PathVariable("code") String code);

    /**
     * 邮件发送
     * @param mail
     * @return CommonResult<Boolean>
     */
    @RequestMapping("/mq/mail")
    public CommonResult<Boolean> sendMail(@RequestBody Mail mail);
}
