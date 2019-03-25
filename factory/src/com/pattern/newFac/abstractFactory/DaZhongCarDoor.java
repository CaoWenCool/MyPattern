package com.pattern.newFac.abstractFactory;

/**
 * @author: admin
 * @create: 2019/3/25
 * @update: 12:05
 * @version: V1.0
 * @detail:
 **/
public class DaZhongCarDoor implements CarDoor{
    @Override
    public void installCarDoor() {
        System.out.print("安装了大众的车门");
    }
}
