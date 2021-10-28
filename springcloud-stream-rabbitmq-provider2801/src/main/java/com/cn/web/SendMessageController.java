package com.cn.web;

import com.cn.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author nchen
 * @Date 2021/10/28 13:54
 * @Version 1.0
 * @Description
 */
@RestController
public class SendMessageController {
    @Autowired
    private IMessageProvider messageProvider;


    @RequestMapping("/sendMessage")
    public  String sendMessage(){
        return  messageProvider.send();
    }
}
