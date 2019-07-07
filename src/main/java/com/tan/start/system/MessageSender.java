package com.tan.start.system;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MessageSender {

    private Logger logger = LoggerFactory.getLogger(MessageSender.class);

    @Autowired
    private StringRedisTemplate redisTemplate;


    public void sendMessage(Message message){
        String msg = JSON.toJSONString(message);
        logger.info("send : {}", msg);
        redisTemplate.convertAndSend("message",msg);
    }

//    private static AtomicInteger count = new AtomicInteger(0);
    private static int count = 0;
//    @Scheduled(fixedRate = 2000) //间隔2000ms 通过StringRedisTemplate对象向redis消息队列chat频道发布消息
    public void sendMessage(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
//                String msg = String.valueOf(count.incrementAndGet());
                synchronized (this){
                    String msg = String.valueOf(++count);
                    logger.info("Thread{} send:{}", Thread.currentThread().getId(),msg);
                    redisTemplate.convertAndSend("message",msg);
                    logger.info("sent msg{}",msg);
                }
            }
        };

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 200; i++) {
            Future future = exec.submit(runnable); // 返回值Future ;
        }
        exec.shutdown();

    }

}
