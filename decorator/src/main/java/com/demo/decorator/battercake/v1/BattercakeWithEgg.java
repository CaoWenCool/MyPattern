package com.demo.decorator.battercake.v1;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:07
 * @version: V1.0
 * @detail:
 **/
public class BattercakeWithEgg extends Battercake{
    @Override
    protected String getMsg(){
        return super.getMsg()+"+1个鸡蛋";
    }

    @Override
    public int getPrice(){
        return super.getPrice()+1;
    }
}
