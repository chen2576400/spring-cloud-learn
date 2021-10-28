package com.cn.service;

/**
 * @Author nchen
 * @Date 2021/10/28 11:33
 * @Version 1.0
 * @Description
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

//@Service
@EnableBinding(Source.class)//定义消息的推送管道(源头)
public class IMessageProviderImpl implements  IMessageProvider{
    @Autowired
    private MessageChannel output;//消息发送管道(定义的名字必须要和yml定义的通道名称保持一致)

    @Override
    public String send() {
        String serial= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*************serial"+serial);
        return "发送成功";
    }
}
