package com.nepm.neusoft.nepm.mq.service.impl;

import com.nepm.neusoft.nepm.mq.config.MessageHelper;
import com.nepm.neusoft.nepm.mq.config.RabbitConfig;
import com.nepm.neusoft.nepm.mq.service.ProduceService;
import com.neusoft.nepm.common.po.Mail;
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
