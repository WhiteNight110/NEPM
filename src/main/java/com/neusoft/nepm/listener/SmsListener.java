package com.neusoft.nepm.listener;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.neusoft.nepm.common.utils.SmsUtil;
import com.neusoft.nepm.config.SmsProperties;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;

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
            key={"sms.verify.code"}))
    public void listenSms(Map<String, String> msg) throws ClientException {
        if(CollectionUtils.isEmpty(msg))
        {
            //放弃处理
            return;
        }
        String phone=msg.get("phone");
        String code=msg.get("code");

        if (StringUtils.isBlank(phone)||StringUtils.isBlank(code)){
            return;
        }
        SendSmsResponse resp  =this.smsUtil.sendSms(phone,code,prop.getSignName(),prop.getVerifyCodeTemplate());
    }
}

