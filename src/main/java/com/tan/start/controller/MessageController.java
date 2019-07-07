package com.tan.start.controller;

import com.tan.start.system.Message;
import com.tan.start.system.MessageReceiver;
import com.tan.start.system.MessageSender;
import com.tan.start.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msg")
public class MessageController {

    @Autowired
    private MessageSender messageSender;


    @RequestMapping("/send")
    public ResponseResult testSend(String title,String content){
//        Message message = new Message(title,content);
        messageSender.sendMessage();
        return ResponseResult.ok();
    }

}
