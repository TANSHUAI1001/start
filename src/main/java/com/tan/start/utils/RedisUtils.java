package com.tan.start.utils;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class RedisUtils {

    public static void clearAuthorizationCache(){
        flushDB(1);
    }

    public static void flushDB(int db){
        RedisClient redisClient = RedisClient
                .create("redis://localhost:6379");
        StatefulRedisConnection<String, String> connection
                = redisClient.connect();

        RedisCommands<String, String> syncCommands = connection.sync();
        syncCommands.select(db);
        syncCommands.flushdb();
    }
}
