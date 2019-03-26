package com.demo.strategy.pay;

import com.demo.strategy.pay.payport.PayStrategy;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:13
 * @version: V1.0
 * @detail:
 **/
public class PayStrategyTest {
    public static void main(String[] args) {
        //省略商品添加到购物车，再才能够购物车下单
        //直接从点单开始
        Order order = new Order("1","222222222222",324.45);

        //开始支付，选择支付方式
        //每个渠道的具体算法不一致，
        //基本算法固定的
        System.out.println(order.pay(PayStrategy.DEFAULT_PAY));
    }
}
