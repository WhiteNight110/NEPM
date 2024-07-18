package com.nepm.neusoft.nepm.mq.service;

import com.neusoft.nepm.common.po.Mail;

public interface ProduceService {
    public boolean send(Mail mail);
}
