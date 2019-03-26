package com.demo.strategy.pay.payport;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:12
 * @version: V1.0
 * @detail:
 **/
public class WeChatPay extends Payment {

    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 256;
    }
}
