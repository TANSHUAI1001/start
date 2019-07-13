package com.tan.start.config.shiro;

import org.crazycake.shiro.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

public class GenericRedisSerializer extends GenericJackson2JsonRedisSerializer implements RedisSerializer {
}
