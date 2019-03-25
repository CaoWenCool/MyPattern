package com.pattern.newFac.abstractFactory;

/**
 * @author: admin
 * @create: 2019/3/25
 * @update: 12:08
 * @version: V1.0
 * @detail:
 **/
public class AoDiCarDoor implements CarDoor{

    @Override
    public void installCarDoor() {
        System.out.print("安装了奥迪的车门");
    }
}
