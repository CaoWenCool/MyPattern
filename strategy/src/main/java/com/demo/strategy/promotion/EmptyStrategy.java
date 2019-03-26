package com.demo.strategy.promotion;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:07
 * @version: V1.0
 * @detail:
 **/
public class EmptyStrategy implements PromotionStrategy{

    @Override
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}
