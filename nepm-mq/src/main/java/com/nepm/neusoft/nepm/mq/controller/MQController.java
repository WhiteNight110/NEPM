package com.nepm.neusoft.nepm.mq.controller;


import com.nepm.neusoft.nepm.mq.service.SmsService;
import com.neusoft.nepm.common.po.Mail;
import com.nepm.neusoft.nepm.mq.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mq")
public class MQController {

    @Autowired
    private ProduceService testService;

    @Autowired
    private SmsService smsService;

    @PostMapping("/mail")
    public boolean sendMail(@RequestBody Mail mail) {
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
