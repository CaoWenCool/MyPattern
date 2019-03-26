package com.demo.strategy.pay.payport;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:10
 * @version: V1.0
 * @detail:
 **/
public class AliPay extends Payment{

    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    protected double queryBalance(String uid) {
        return 900;
    }
}
