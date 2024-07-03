package com.neusoft.nepm.controller;


import com.neusoft.nepm.po.Admins;
import com.neusoft.nepm.po.Mail;
import com.neusoft.nepm.po.Sms;
import com.neusoft.nepm.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class MQController {

    @Autowired
    private ProduceService testService;

    @PostMapping("/send")
    public boolean sendMail(Mail mail) {
        return testService.send(mail);
    }
}
