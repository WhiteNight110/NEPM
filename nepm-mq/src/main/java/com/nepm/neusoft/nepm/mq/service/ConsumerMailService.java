package com.nepm.neusoft.nepm.mq.service;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

import java.io.IOException;

public interface ConsumerMailService {

    public void consume(Message message, Channel channel) throws IOException;
}
