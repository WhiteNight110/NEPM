package com.neusoft.nepm.feign;

import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.common.api.ValidateCodeVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("captcha")
public interface CaptchaFeignService {

    /**
     * 获取验证码
     * @return 验证码封装类
     */
    @RequestMapping(method = RequestMethod.GET, value = "/captcha")
    public CommonResult<ValidateCodeVo> getCaptcha();

    /**
     * 校验验证码
     * @param captcha
     * @param codeKey
     * @return 校验结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{captcha}/{codeKey}")
    public CommonResult<Boolean> checkCaptcha(@PathVariable("captcha") String captcha,
                                              @PathVariable("codeKey") String codeKey);

}
