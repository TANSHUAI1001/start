package com.tan.start.utils;

import com.tan.start.utils.datatable.PageParam;

import java.util.HashMap;

public class ResponseResult extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    // 成功
    private static final Integer SUCCESS = 1;
    // 警告
    private static final Integer WARN = 2;
    // 异常 失败
    private static final Integer FAIL = 0;

    public static final String CODE = "code";
    public static final String MSG = "msg";
    public static final String DATA = "data";
    public static final String ERROR = "error";
    public static final String SUCCESS_MSG = "操作成功!";
    public static final String FAIL_MSG = "操作失败!";

    public static final String DRAW = "draw";
    public static final String START = "start";
    public static final String LENGTH = "length";
    public static final String RECORDS_TOTAL = "recordsTotal";
    public static final String RECORDS_FILTERED = "recordsFiltered";


    public ResponseResult() {
        put(CODE, SUCCESS);
        put(MSG, SUCCESS_MSG);
    }

    public static ResponseResult error(Object msg) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.put(CODE, FAIL);
        responseResult.put(MSG, msg);
        responseResult.put(ERROR,msg);
        return responseResult;
    }

    public static ResponseResult warn(Object msg) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.put(CODE, WARN);
        responseResult.put(MSG, msg);
        return responseResult;
    }

    public static ResponseResult ok(Object msg) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.put(CODE, SUCCESS);
        responseResult.put(MSG, msg);
        return responseResult;
    }

    public static ResponseResult ok() {
        return new ResponseResult();
    }

    public static ResponseResult error() {
        return ResponseResult.error(FAIL_MSG);
    }

    public ResponseResult putAttr(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public ResponseResult putBaseAttr(PageParam pageParam) {
        super.put(DRAW, pageParam.getDraw());
        super.put(START, pageParam.getStart());
        super.put(LENGTH, pageParam.getLength());
        return this;
    }
}