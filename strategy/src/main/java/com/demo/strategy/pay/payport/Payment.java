package com.demo.strategy.pay.payport;

import com.demo.strategy.pay.MsgResult;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:10
 * @version: V1.0
 * @detail:
 **/
public abstract class Payment {
    //支付类型
    public abstract String getName();
    //余额查询
    protected abstract double queryBalance(String uid);
    //扣款支付
    public MsgResult pay(String uid, double amount){
        if(queryBalance(uid)<amount){
            return new MsgResult(500,"支付失败","余额不足");
        }
        return new MsgResult(200,"支付成功，","支付金额"+amount);
    }
}
