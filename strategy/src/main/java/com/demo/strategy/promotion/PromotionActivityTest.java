package com.demo.strategy.promotion;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:08
 * @version: V1.0
 * @detail:
 **/
public class PromotionActivityTest {

    public static void main(String[] args) {
        PromotionActivity activity = new PromotionActivity(new CouponStrategy());
        PromotionActivity activity1 = new PromotionActivity(new CashbackStrategy());

        activity.execute();
        activity1.execute();
    }
}
