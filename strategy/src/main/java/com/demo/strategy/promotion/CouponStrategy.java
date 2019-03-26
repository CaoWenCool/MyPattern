package com.demo.strategy.promotion;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:07
 * @version: V1.0
 * @detail:
 **/
public class CouponStrategy implements PromotionStrategy{

    @Override
    public void doPromotion() {
        System.out.println("领取优惠券，课程的价格直接减优惠券面值抵扣");
    }

}
