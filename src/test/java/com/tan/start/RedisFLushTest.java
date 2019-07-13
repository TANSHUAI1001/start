package com.tan.start;

import com.tan.start.utils.RedisUtils;
import org.junit.Test;

public class RedisFLushTest {

    @Test
    public void flushDB(){
        RedisUtils.flushDB(1);
    }
}
