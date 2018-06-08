package com.anji.springwebsocketdemo.controller;

import com.anji.springwebsocketdemo.model.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Description:
 * author: chenqiang
 * date: 2018/6/8 9:41
 */
@Controller
public class WebSocketController {

    @Resource
    private SimpMessagingTemplate messagingTemplate;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @MessageMapping("/welcome")
    public ResponseMessage toTopic(ResponseMessage msg) throws Exception {
        System.out.println("======================" + msg.getMessage());
        this.messagingTemplate.convertAndSend("/spi/v1/socket/send", msg.getMessage());
        return new ResponseMessage("欢迎使用websocket：" + msg.getMessage());
    }

    @MessageMapping("/message")
    public ResponseMessage toUser(ResponseMessage msg) {
        System.out.println(msg.getMessage());
        this.messagingTemplate.convertAndSendToUser("123","/message",msg.getMessage());
        return new ResponseMessage("欢迎使用websocket："+msg.getMessage());
    }
}
