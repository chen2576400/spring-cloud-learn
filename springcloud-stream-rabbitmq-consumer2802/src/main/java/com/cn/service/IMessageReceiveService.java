package com.cn.service;

/**
 * @Author nchen
 * @Date 2021/10/28 11:33
 * @Version 1.0
 * @Description
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)//定义消息的推送管道(接收)
public class IMessageReceiveService {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message) {
        System.out.println("消费者1号，-------->接受到的消息"+message.getPayload()+"\t  port:"+serverPort);
    }
}
