package com.tan.start.utils;

import com.tan.start.query.Query;

import java.util.*;

/**
 * 建议使用
 * @see org.springframework.http.ResponseEntity
 * @see com.github.pagehelper.PageInfo
 * @see ResponseContent
 */
@Deprecated
public class ResponseResult extends TreeMap<String, Object> {
    // 普通对象按顺序序列化
    // 有序的TreeMap，map需要指定顺序

    private static final long serialVersionUID = -8713837118340960775L;

    // 成功
    private static final Integer SUCCESS = 1;
    // 警告
    private static final Integer WARN = 2;
    // 异常 失败
    private static final Integer FAIL = 0;

    public static final String SUCCESS_MSG = "操作成功!";
    public static final String FAIL_MSG = "操作失败!";

    public static final String CODE = "code";
    public static final String MSG = "msg";
    public static final String DATA = "data";
    public static final String ERROR = "error";

    public static final String DRAW = "draw";
    public static final String START = "start";
    public static final String LENGTH = "length";
    public static final String RECORDS_TOTAL = "recordsTotal";
    public static final String RECORDS_FILTERED = "recordsFiltered";

    private static HashMap<String,Integer> priority = new HashMap<>();
    static {
        priority.put(CODE,10);
        priority.put(MSG,20);
        priority.put(ERROR,21);
        priority.put(DRAW,30);
        priority.put(START,40);
        priority.put(LENGTH,50);
        priority.put(RECORDS_FILTERED,60);
        priority.put(RECORDS_TOTAL,70);
        priority.put(DATA,80);
    }

    public ResponseResult() {
        super((o1, o2) -> {
            if(priority.containsKey(o1) && priority.containsKey(o2)){
                return priority.get(o1) - priority.get(o2);
            }else if(priority.containsKey(o1) && !priority.containsKey(o2)){
                return -1;
            }else if(!priority.containsKey(o1) && priority.containsKey(o2)){
                return 1;
            }
            return o1.compareTo(o2);
        });

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
        ResponseResult responseResult = new ResponseResult();
        responseResult.put(CODE, SUCCESS);
        responseResult.put(MSG, SUCCESS_MSG);
        return responseResult;
    }

    public static ResponseResult error() {
        return ResponseResult.error(FAIL_MSG);
    }

    public ResponseResult putAttr(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public ResponseResult putDataAttr(Object data) {
        super.put(DATA, data);
        return this;
    }

    public ResponseResult putBaseAttr(Query query) {
        super.put(DRAW, query.getDraw());
        super.put(START, query.getStart());
        super.put(LENGTH, query.getLength());
        return this;
    }

    public ResponseResult putBaseAttr(Query query,long total) {
        super.put(DRAW, query.getDraw());
        super.put(START, query.getStart());
        super.put(LENGTH, query.getLength());
        super.put(RECORDS_TOTAL, total);
        super.put(RECORDS_FILTERED, total);
        return this;
    }
}