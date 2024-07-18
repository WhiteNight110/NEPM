package com.neusoft.nepm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.nepm.common.api.ValidateCodeVo;

public interface CaptchaService  extends IService<ValidateCodeVo> {

    /**
     * 生成验证码
     * @return ValidateCodeVo
     */
    ValidateCodeVo generateValidateCode();

    /**
     * 验证码校验
     * @param captcha
     * @param codeKey
     * @return Boolean
     */
    Boolean verifyValidateCode(String captcha, String codeKey);
}
