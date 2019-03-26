package com.demo.strategy.promotion;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:06
 * @version: V1.0
 * @detail:
 **/
public class CashbackStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("返现促销，返回的金额转到支付宝账户");
    }
}
