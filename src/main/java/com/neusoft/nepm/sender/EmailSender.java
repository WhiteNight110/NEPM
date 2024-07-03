//package com.neusoft.nepm.sender;
//
//
//import com.alibaba.fastjson.JSON;
//import com.neusoft.nepm.po.Admins;
//import com.neusoft.nepm.po.Mail;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.core.MessageBuilder;
//import org.springframework.amqp.core.MessageDeliveryMode;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.connection.CorrelationData;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.SerializerMessageConverter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//
//
////邮件生产者
//@Component
//public class EmailSender {
//
//
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Resource(name = "rabbitTemplatePrototype")
//    private RabbitTemplate rabbitTemplate;
//
//
//
//    // 从配置文件读取邮件队列的名称
//    @Value("${rabbitmq.email.queue}")
//    private String emailQueue;
//
//
//    /**
//     * 发送邮件消息到队列
//     *
//     * @param user     收件人信息
//     * @param message  邮件消息内容
//     */
//    public void send(Admins user, String message) {
//
//
//        // 1.创建 EmailMessage 对象，封装收件人和邮件消息
//        Mail emailMessage = new Mail(user,message);
//
//        // 2.将 EmailMessage 对象转换为字节数组
//        byte[] bytes = JSON.toJSONBytes(emailMessage);
//
//        // 3.创建消息对象，并设置消息体和持久化属性
//        Message rabbitMessage  = MessageBuilder.withBody(bytes)
//                .setDeliveryMode(MessageDeliveryMode.PERSISTENT)
//                .build();
//
//        // 4.发送消息到邮件队列
//        rabbitTemplate.send(emailQueue,rabbitMessage);
//    }
//
//    //  init 方法被标记为 @PostConstruct，这意味着它会在 目前该Bean 被创建并完成依赖注入后调用。
//    // 当 Spring 容器创建 MyBean 时，会自动调用 initialize 方法。
//    @PostConstruct
//    public void init() {
//
//        // 设置发送成功消息确认回调函数
//        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
//            @Override
//            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//                if (ack) {
//                    // 发送成功的处理逻辑
//                    logger.info("邮件消息投递成功！");
//
//                } else {
//                    // 发送失败的处理逻辑
//                    logger.error("邮件消息投递失败！");
//                    logger.error("ConfirmCallback: 相关数据 :{}",correlationData);
//                    logger.error("ConfirmCallback: 确认情况 :{}",ack);
//                    logger.error("ConfirmCallback: 原因 :{}",cause);
//
//                }
//            }
//        });
//
//        // 设置消息退回回调函数
//        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
//            @Override
//            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
//                // 处理退回的消息
//                String returnedMessage = new String(message.getBody());
//
//                logger.error("消息退回到生产者！");
//                logger.error("退回的消息 : {}",returnedMessage);
//                logger.error("回复代码 : {}",replyCode);
//                logger.error("回复文本 : {}",replyText);
//                logger.error("交换机 : {}",exchange);
//                logger.error("路由键 : {}",routingKey);
//
//
//                // 在这里进行退回消息的处理逻辑
//            }
//        });
//
//    }
//}
