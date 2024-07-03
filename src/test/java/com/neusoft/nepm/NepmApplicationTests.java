package com.neusoft.nepm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;

@EnableTransactionManagement
@SpringBootTest
class NepmApplicationTests {

    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    void contextLoads() {
    }
    @Test
    public void test5(){
        //构建邮件内容对象
        SimpleMailMessage msg = new SimpleMailMessage();
        //邮件发送者
        msg.setFrom("1368387047@qq.com");
        //邮件接收者
        msg.setTo("1368387047@qq.com");
        //邮件主题
        msg.setSubject("测试邮件主题");
        //邮件正文
        msg.setText("测试邮件内容");
        //邮件发送时间
        msg.setSentDate(new Date());
        //邮件发送
        javaMailSender.send(msg);

    }



}
