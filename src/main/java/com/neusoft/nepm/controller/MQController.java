package com.neusoft.nepm.controller;


import com.neusoft.nepm.po.Admins;
import com.neusoft.nepm.po.Mail;
import com.neusoft.nepm.po.Sms;
import com.neusoft.nepm.service.ProduceService;
import com.neusoft.nepm.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class MQController {

    @Autowired
    private ProduceService testService;

    @Autowired
    private SmsService smsService;

    @PostMapping("/mail")
    public boolean sendMail(Mail mail) {
        return testService.send(mail);
    }

    @PostMapping("/sms")
    public ResponseEntity<Void> sendVerifyCode(@RequestParam String phone){
        Boolean aBoolean = this.smsService.sendVerifyCode(phone);
        if (!aBoolean){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
