package com.demo.strategy.promotion;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:08
 * @version: V1.0
 * @detail:
 **/
public class PromotionActivity {

    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy){
        this.promotionStrategy = promotionStrategy;
    }

    public void execute(){
        promotionStrategy.doPromotion();
    }
}
