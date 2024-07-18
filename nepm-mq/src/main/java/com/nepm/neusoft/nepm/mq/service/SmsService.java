package com.nepm.neusoft.nepm.mq.service;

public interface SmsService {
    public Boolean sendVerifyCode(String phone);

    public Boolean verifySms(String phone, String code);
}
