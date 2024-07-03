package com.neusoft.nepm.service;

import org.springframework.amqp.core.Message;
import java.io.IOException;
import com.rabbitmq.client.Channel;

public interface ConsumerMailService {

    public void consume(Message message, Channel channel) throws IOException;
}
