package com.demo.adapter.loginadapter;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:17
 * @version: V1.0
 * @detail:
 **/
public class ResultMsg {

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Object data;
    public ResultMsg(int code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
