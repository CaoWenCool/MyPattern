package com.demo.strategy.promotion;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:08
 * @version: V1.0
 * @detail:
 **/
public class GroupbuyStrategy implements PromotionStrategy{

    @Override
    public void doPromotion() {
        System.out.println("拼团，满20人成团，全团享受价格优惠");
    }
}
