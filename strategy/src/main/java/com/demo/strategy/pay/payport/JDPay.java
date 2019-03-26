package com.demo.strategy.pay.payport;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:11
 * @version: V1.0
 * @detail:
 **/
public class JDPay extends Payment{

    @Override
    public String getName() {
        return "京东白条";
    }

    @Override
    protected double queryBalance(String uid) {
        return 500;
    }
}
