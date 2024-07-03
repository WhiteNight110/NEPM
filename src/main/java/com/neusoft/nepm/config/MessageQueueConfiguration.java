//package com.neusoft.nepm.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.AcknowledgeMode;
//import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitAdmin;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.Scope;
//
//@Slf4j
//@Configuration
//public class MessageQueueConfiguration {
//
//    @Value("${spring.rabbitmq.template.reply-timeout:1800000}")
//    private Integer replyTimeout;
//    /**
//     * 存在此名字的bean 自带的容器工厂会不加载（yml下rabbitmq下的template的配置），
//     * 如果想自定义来区分开 需要改变bean 的名称
//     * 配置的其他的bean也都遵循这个规则配置
//     * @param connectionFactory
//     * @return
//     */
//    @Bean(name = "rabbitTemplatePrototype")
//    //设置为多实例的,每次注入都使用不同的bean
//    @Scope("prototype")
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory);
//        /**
//         * 单位:毫秒
//         * 同步消息方法convertSendAndReceive(),发送端等待接收消费端给出return msg的时间
//         */
//        template.setReplyTimeout(replyTimeout);
//        template.setMessageConverter(new Jackson2JsonMessageConverter());
//        initMessageSendConfirm(template);
//        return template;
//    }
//
//    @Bean
//    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
//        return new RabbitAdmin(connectionFactory);
//    }
//
//    @Bean
//    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        //设置手动ACK
//        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        factory.setMessageConverter(new Jackson2JsonMessageConverter());
//        return factory;
//    }
//
//    @Bean(name = "connectionFactory")
//    @Primary
//    public ConnectionFactory connectionFactory(@Value("${spring.rabbitmq.host}") String host,
//                                               @Value("${spring.rabbitmq.port}") int port,
//                                               @Value("${spring.rabbitmq.username}") String username,
//                                               @Value("${spring.rabbitmq.password}") String password) {
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//        connectionFactory.setHost(host);
//        connectionFactory.setPort(port);
//        connectionFactory.setUsername(username);
//        connectionFactory.setPassword(password);
//        connectionFactory.setVirtualHost("/");
//        connectionFactory.setRequestedHeartBeat(60);
//
//        /**
//         * CORRELATED:异步回调，消息发送到交换机时会回调这个ConfirmCallback
//         * SIMPLE:则不会出发ConfirmCallback
//         */
//        connectionFactory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.CORRELATED);
//        return connectionFactory;
//    }
//
//    private void initMessageSendConfirm(RabbitTemplate rabbitTemplate) {
//        /**
//         * ConfirmCallback为发送Exchange（交换器）时回调，成功或者失败都会触发；
//         */
//        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
//            if (ack) {
//                log.info("消息发送到exchange成功");
//            } else {
//                log.error("消息发送到exchange失败,原因: {}, CorrelationData: {}", cause,
//                        correlationData);
//            }
//        });
//        /**
//         * Mandatory为true时,消息通过交换器无法匹配到队列会返回给生产者 并触发ReturnCallback
//         * 为false时,匹配不到会直接被丢弃
//         */
//        /**
//         * Mandatory为true时,消息通过交换器无法匹配到队列会返回给生产者 并触发ReturnCallback
//         * 为false时,匹配不到会直接被丢弃
//         *
//         * spring.rabbitmq.template.mandatory属性的优先级高于spring.rabbitmq.publisher-returns的优先级
//         * 一般不设置publisher-returns
//         * spring.rabbitmq.template.mandatory属性可能会返回三种值null、false、true.
//         * spring.rabbitmq.template.mandatory结果为true、false时会忽略掉spring.rabbitmq.publisher-returns属性的值
//         * spring.rabbitmq.template.mandatory结果为null（即不配置）时结果由spring.rabbitmq.publisher-returns确定
//         */
//        rabbitTemplate.setMandatory(true);
//        /**
//         * ReturnCallback为路由不到队列时触发，成功则不触发；
//         */
//        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
//            log.error("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", message,
//                    replyCode, replyText,
//                    exchange, routingKey);
//        });
//    }
//}
//
