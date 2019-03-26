package com.demo.strategy.pay;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:09
 * @version: V1.0
 * @detail:
 **/
public class MsgResult {
    private int code;
    private Object data;
    private String msg;

    public MsgResult(int code,String msg,Object data){
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public String toString(){
        return ("支付状态：【"+code+"]"+msg+"交易详情"+data);
    }
}
