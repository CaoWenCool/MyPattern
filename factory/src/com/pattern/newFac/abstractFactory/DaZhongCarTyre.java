package com.pattern.newFac.abstractFactory;

/**
 * @author: admin
 * @create: 2019/3/25
 * @update: 12:06
 * @version: V1.0
 * @detail:
 **/
public class DaZhongCarTyre implements CarTyre{
    @Override
    public void instalTyre() {
        System.out.print("安装了大众的轮胎");
    }
}
