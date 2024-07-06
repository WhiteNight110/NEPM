package com.neusoft.nepm.listener;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.neusoft.nepm.common.utils.SmsUtil;
import com.neusoft.nepm.config.SmsProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Component
@EnableConfigurationProperties(SmsProperties.class)
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;

    @Autowired
    private SmsProperties prop;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "LEYOU.SMS.QUEUE", durable = "true"),
            exchange = @Exchange(value = "LEYOU.SMS.EXCHANGE", ignoreDeclarationExceptions = "true"),
            key = {"sms.verify.code"}))
    public void listenSms(Map<String, String> msg, org.springframework.amqp.core.Message message, com.rabbitmq.client.Channel channel) throws IOException, ClientException {
        if (CollectionUtils.isEmpty(msg)) {
            // 放弃处理
            return;
        }
        String phone = msg.get("phone");
        String code = msg.get("code");

        if (StringUtils.isBlank(phone) || StringUtils.isBlank(code)) {
            // 可能需要记录或处理无效消息
            return;
        }

        try {
            SendSmsResponse resp = this.smsUtil.sendSms(phone, code, prop.getSignName(), prop.getVerifyCodeTemplate());
            log.info("Successfully sent SMS to phone: {}, response: {}", phone, resp);

            // 手动确认消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (ClientException e) {
            log.error("Failed to send SMS to phone: {}, error: {}", phone, e.getMessage());

            // 可以根据需要处理发送失败的逻辑，例如记录日志或进行重试

            // 拒绝并重新放回队列（如果需要）
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        }
    }
}

