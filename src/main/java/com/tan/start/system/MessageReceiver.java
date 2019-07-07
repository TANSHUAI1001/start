package com.tan.start.system;

import com.alibaba.fastjson.JSON;
import com.tan.start.entity.Activity;
import com.tan.start.entity.FundData;
import com.tan.start.service.ActivityService;
import com.tan.start.service.FundDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MessageReceiver {

    @Resource
    private ActivityService activityService;

    private Logger logger = LoggerFactory.getLogger(MessageReceiver.class);

    public void receiveMessage(String message){
//        Message receiveMsg = JSON.parseObject(message,Message.class);
//        logger.info("receive : {},{}",receiveMsg.getTitle(),receiveMsg.getContent());
        Activity activity = activityService.findById(1005L+Long.valueOf(message) % 6);
        logger.info("receive:{}. {}",message,activity==null);
    }
}
