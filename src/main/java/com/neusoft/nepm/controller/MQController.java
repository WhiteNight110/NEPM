package com.neusoft.nepm.controller;

import com.neusoft.nepm.config.MessageQueueHelper;
import com.neusoft.nepm.po.Mail;
import com.neusoft.nepm.po.Sms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class MQController {
    @Autowired
    private MessageQueueHelper messageQueueHelper;

    @PostMapping("/send")
    public String sendMessages() {
        Mail mail = new Mail("1", "我是邮件");
        messageQueueHelper.sendMessage("message_ex", "mail.send", "mail", mail);

        Sms sms = new Sms("1", "我是短信");
        messageQueueHelper.sendMessage("message_ex", "sms.send", "sms", sms);

        return "{\"message\":\"消息已发送\"}";
    }
}
