package com.neusoft.nepm.service.impl;

import com.neusoft.nepm.config.MessageHelper;
import com.neusoft.nepm.config.RabbitConfig;
import com.neusoft.nepm.po.Mail;
import com.neusoft.nepm.service.ProduceService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProduceServiceImpl implements ProduceService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public boolean send(Mail mail) {
        //创建uuid
        String msgId = UUID.randomUUID().toString().replaceAll("-", "");
        mail.setMsgId(msgId);

        //发送消息到rabbitMQ
        CorrelationData correlationData = new CorrelationData(msgId);
        rabbitTemplate.convertAndSend(RabbitConfig.MAIL_EXCHANGE_NAME, RabbitConfig.MAIL_ROUTING_KEY_NAME, MessageHelper.objToMsg(mail), correlationData);

        return true;
    }
}
