package com.neusoft.nepm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.nepm.common.api.ValidateCodeVo;
import com.neusoft.nepm.po.Aqi;

public interface CaptchaService  extends IService<ValidateCodeVo> {

    ValidateCodeVo generateValidateCode();

    boolean verifyValidateCode(String captcha, String codeKey);
}
