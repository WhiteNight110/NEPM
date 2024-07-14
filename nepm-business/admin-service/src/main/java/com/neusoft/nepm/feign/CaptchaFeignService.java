package com.neusoft.nepm.feign;

import com.neusoft.nepm.common.api.ValidateCodeVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("captcha")
public interface CaptchaFeignService {

    @RequestMapping("/captcha/getCaptcha")
    public ValidateCodeVo getCaptcha();

    @RequestMapping("/captcha/checkCaptcha")
    public boolean checkCaptcha(@RequestParam("captcha") String captcha, @RequestParam("codeKey") String codeKey);

}
