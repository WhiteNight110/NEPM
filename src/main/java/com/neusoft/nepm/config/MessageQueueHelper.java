//package com.neusoft.nepm.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.amqp.rabbit.core.RabbitAdmin;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//import java.util.UUID;
//
//@Slf4j
//@Component
//public class MessageQueueHelper {
//    @Resource
//    private RabbitTemplate rabbitTemplate;
//    @Resource
//    private RabbitAdmin rabbitAdmin;
//
//    @PostConstruct
//    public void init() {
//        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
//    }
//
//    /**
//     * 发送异步消息,根据参数动态创建交换机、队列，和业务更解耦
//     *
//     * @param exchangeName
//     * @param queueName
//     * @param sendMessage
//     */
//    public void sendMessage(String exchangeName, String queueName, String routingKey, Object sendMessage) {
//        try {
//            TopicExchange exchange = new TopicExchange(exchangeName);
//            rabbitAdmin.declareExchange(exchange);
//
//            Queue queue = new Queue(queueName);
//            rabbitAdmin.declareQueue(queue);
//            String simpleName = sendMessage.getClass().getSimpleName();
//            /**
//             * *(星号)可以代替一个单词
//             * #(井号)可以替代零个或多个单词
//             */
//            rabbitAdmin.declareBinding(BindingBuilder
//                    .bind(queue)
//                    .to(exchange)
//                    .with(simpleName.toLowerCase() + ".#"));
//
//            rabbitTemplate.convertAndSend(exchangeName, routingKey, sendMessage, message -> {
//                /**
//                 * 指定消费结果返回的队列
//                 */
//                message.getMessageProperties().setReplyTo("result-stu");
//                message.getMessageProperties().setCorrelationId(UUID.randomUUID().toString());
//                return message;
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 发送同步消息
//     *
//     * @param exchangeName
//     * @param queueName
//     * @param sendMessage
//     */
//    public void sendMessageAndReceive(String exchangeName, String queueName, Object sendMessage) {
//        try {
//            TopicExchange exchange = new TopicExchange(exchangeName);
//            rabbitAdmin.declareExchange(exchange);
//
//            Queue queue = new Queue(queueName);
//            rabbitAdmin.declareQueue(queue);
//            /**
//             * *(星号)可以代替一个单词
//             * #(井号)可以替代零个或多个单词
//             */
//            String routingKey = "vm.#";
//            rabbitAdmin.declareBinding(BindingBuilder
//                    .bind(queue)
//                    .to(exchange)
//                    .with(routingKey));
//
//            Object o = rabbitTemplate.convertSendAndReceive(exchangeName, "vm.fff", sendMessage);
//            System.out.println(o);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
