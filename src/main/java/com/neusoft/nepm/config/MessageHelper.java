package com.neusoft.nepm.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

public class MessageHelper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Message objToMsg(Object obj) {
        try {
            String json = objectMapper.writeValueAsString(obj);
            return new Message(json.getBytes(), new MessageProperties());
        } catch (JsonProcessingException e) {
            throw new MessageConversionException("Error converting object to JSON", e);
        }
    }
}

