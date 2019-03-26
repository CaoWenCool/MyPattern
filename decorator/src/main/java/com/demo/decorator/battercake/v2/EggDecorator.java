package com.demo.decorator.battercake.v2;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:10
 * @version: V1.0
 * @detail:
 **/
public class EggDecorator extends BattercakeDecorator{

    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected void adSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg()+"+1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice()+1;
    }
}
