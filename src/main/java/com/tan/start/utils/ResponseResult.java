package com.tan.start.utils;

import java.util.HashMap;

public class ResponseResult extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    // 成功
    private static final Integer SUCCESS = 1;
    // 警告
    private static final Integer WARN = 2;
    // 异常 失败
    private static final Integer FAIL = 0;

    public ResponseResult() {
        put("code", SUCCESS);
        put("msg", "操作成功");
    }

    public static ResponseResult error(Object msg) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.put("code", FAIL);
        responseResult.put("msg", msg);
        responseResult.put("error",msg);
        return responseResult;
    }

    public static ResponseResult warn(Object msg) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.put("code", WARN);
        responseResult.put("msg", msg);
        return responseResult;
    }

    public static ResponseResult ok(Object msg) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.put("code", SUCCESS);
        responseResult.put("msg", msg);
        return responseResult;
    }

    public static ResponseResult ok() {
        return new ResponseResult();
    }

    public static ResponseResult error() {
        return ResponseResult.error("");
    }

    @Override
    public ResponseResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}