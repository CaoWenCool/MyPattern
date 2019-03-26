package com.demo.decorator.battercake.v1;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:07
 * @version: V1.0
 * @detail:
 **/
public class BattercakeWithEggAndSausage extends BattercakeWithEgg{
    @Override
    protected String getMsg() {
        return super.getMsg()+"+1根香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice()+2;
    }
}
