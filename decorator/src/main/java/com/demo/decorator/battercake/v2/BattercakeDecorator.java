package com.demo.decorator.battercake.v2;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:09
 * @version: V1.0
 * @detail:
 **/
public abstract class BattercakeDecorator extends Battercake{
    //静态代理，委派
    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake){
        this.battercake = battercake;
    }

    protected abstract void adSomething();
    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.battercake.getPrice();
    }
}
