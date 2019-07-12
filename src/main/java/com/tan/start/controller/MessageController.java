package com.tan.start.controller;

import com.tan.start.system.MessageSender;
import com.tan.start.utils.ResponseContent;
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
    public ResponseContent testSend(String title, String content){
        messageSender.sendMessage();
        return ResponseContent.ok();
    }

}
