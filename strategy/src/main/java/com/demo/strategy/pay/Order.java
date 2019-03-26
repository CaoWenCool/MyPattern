package com.demo.strategy.pay;

import com.demo.strategy.pay.payport.PayStrategy;
import com.demo.strategy.pay.payport.Payment;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:09
 * @version: V1.0
 * @detail:
 **/
public class Order {
    private String uid;
    private String orderId;
    private double amount;

    public Order(String uid,String orderId,double amount){
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }


    public MsgResult pay(){
        return pay(PayStrategy.DEFAULT_PAY);
    }

    public MsgResult pay(String payKey){
        Payment payment = PayStrategy.get(payKey);
        System.out.println("欢迎使用"+payment.getName());
        System.out.println("本次交易金额为："+amount+"开始扣款……");
        return payment.pay(uid,amount);
    }
}

