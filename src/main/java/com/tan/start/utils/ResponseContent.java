package com.tan.start.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.pagehelper.Page;
import com.tan.start.query.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Reference
 * @see com.github.pagehelper.PageInfo
 * @see com.github.pagehelper.PageSerializable
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseContent<T> implements Serializable {
    private static final long serialVersionUID = -3692406475940577319L;
    private static final int SUCCESS = 1;
    private static final int FAIL = 0;
    private static final String SUCCESS_MSG = "操作成功!";
    private static final String FAIL_MSG = "操作失败!";

    protected int code;
    protected int draw;
    protected int start;
    protected int length;

    protected long recordsFiltered;
    protected long recordsTotal;
    protected List<T> data;
    protected String error;
    protected String msg;

    public ResponseContent() {
    }

    public ResponseContent(String msg) {
        super();
        this.msg = msg;
    }

    public ResponseContent(List<T> list) {
        this.data = list;
        if(list instanceof Page){
            this.recordsTotal = ((Page)list).getTotal();
        } else {
            this.recordsTotal = list.size();
        }
        this.recordsFiltered = this.recordsTotal;
    }

    public static <T> ResponseContent<T> ok(){
        return new ResponseContent<T>().putCode(SUCCESS).putMsg(SUCCESS_MSG);
    }

    public static <T> ResponseContent<T> ok(List<T> list){
        return new ResponseContent<>(list).putCode(SUCCESS).putMsg(SUCCESS_MSG);
    }

    public static <T> ResponseContent<T> fail(){
        return new ResponseContent<T>(FAIL_MSG).putCode(FAIL);
    }

    public static <T> ResponseContent<T> fail(String msg){
        return new ResponseContent<T>(msg).putCode(FAIL);
    }

    public static <T> ResponseContent<T> error(){
        return new ResponseContent<T>().putCode(FAIL).putError(FAIL_MSG);
    }

    public static <T> ResponseContent<T> error(String msg){
        return new ResponseContent<T>().putCode(FAIL).putError(msg);
    }

    public ResponseContent<T> putQuery(Query query){
        this.setDraw(query.getDraw());
        this.setStart(query.getStart());
        this.setLength(query.getLength());
        return this;
    }

    public ResponseContent<T> putCode(int code){
        this.setCode(code);
        return this;
    }

    public ResponseContent<T> putMsg(String msg){
        this.setMsg(msg);
        return this;
    }

    public ResponseContent<T> putError(String msg){
        this.setError(msg);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
