package com.pattern.newFac.abstractFactory;

/**
 * @author: admin
 * @create: 2019/3/25
 * @update: 12:09
 * @version: V1.0
 * @detail:
 **/
public class AoDiCarTyre implements CarTyre{
    @Override
    public void instalTyre() {
        System.out.print("安装了奥迪的轮胎");
    }
}
