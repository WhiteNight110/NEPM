//package com.neusoft.nepm.consumer;
//
//import com.alibaba.fastjson.JSON;
//import com.neusoft.nepm.po.Admins;
//import com.neusoft.nepm.po.Mail;
//import com.neusoft.nepm.service.EmailService;
//import com.rabbitmq.client.Channel;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.validation.constraints.Email;
//
//@Component
//public class EmailConsumer implements ChannelAwareMessageListener {
//
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private EmailService emailService;
//
//
//    @Override
//    @RabbitListener(queues = "${rabbitmq.email.queue}")
//    public void onMessage(Message message, Channel channel) throws Exception {
//
//        try {
//            // 从消息中获取消息体（消息的字节数组）
//            byte[] messageBody = message.getBody();
//            // 将消息体转换为 EmailMessage 对象
//            Mail email = JSON.parseObject(messageBody, Mail.class);
//
//            // 从 EmailMessage 对象中提取用户和邮件消息内容
//            Admins user = new Admins();
//            String content = email.getContent();
//
//            emailService.sendMail(user, content);
//
//            // 手动确认消息
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//        } catch (Exception e) {
//
//            // 发生异常时选择拒绝消息
//            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
//            logger.error("邮件发送时发生异常！丢弃该消息！");
//            e.printStackTrace();
//
//
//        }
//    }
//}
