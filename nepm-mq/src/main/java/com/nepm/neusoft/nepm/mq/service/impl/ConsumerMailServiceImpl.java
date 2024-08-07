package com.nepm.neusoft.nepm.mq.service.impl;

import com.nepm.neusoft.nepm.mq.config.RabbitConfig;
import com.nepm.neusoft.nepm.mq.service.ConsumerMailService;
import com.nepm.neusoft.nepm.mq.util.SendMailUtil;
import com.neusoft.nepm.common.po.Mail;
import com.neusoft.nepm.common.utils.JsonUtil;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConsumerMailServiceImpl implements ConsumerMailService {
    @Autowired
    private SendMailUtil sendMailUtil;

    @RabbitListener(queues = RabbitConfig.MAIL_QUEUE_NAME)
    public void consume(Message message, Channel channel) throws IOException {
        //将消息转化为对象
        String str = new String(message.getBody());
        Mail mail = JsonUtil.strToObj(str, Mail.class);
        assert mail != null;
        System.out.println("收到消息: { " +  mail + " }");

        MessageProperties properties = message.getMessageProperties();
        long tag = properties.getDeliveryTag();

        boolean success = sendMailUtil.send(mail);
        if (success) {
            channel.basicAck(tag, false);// 消费确认
        } else {
            channel.basicNack(tag, false, true);
        }
    }


}
