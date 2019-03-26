package com.demo.decorator.battercake.v2;


/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:08
 * @version: V1.0
 * @detail:
 **/
public class BaseBattercake extends Battercake{
    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    public int getPrice() {
        return 5;
    }
}
