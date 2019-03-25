package com.pattern.newFac.abstractFactory;

/**
 * @author: admin
 * @create: 2019/3/25
 * @update: 12:07
 * @version: V1.0
 * @detail:
 **/
public class JiLiCarDoor implements CarDoor{
    @Override
    public void installCarDoor() {
        System.out.print("安装了吉利的车门");
    }
}
