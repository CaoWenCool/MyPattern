package com.pattern.newFac.abstractFactory;

/**
 * @author: admin
 * @create: 2019/3/25
 * @update: 12:06
 * @version: V1.0
 * @detail:
 **/
public class DaZhongFactory implements CarFactory{
    @Override
    public CarDoor installCarDoor() {
        return new DaZhongCarDoor();
    }

    @Override
    public CarTyre installCarTyre() {
        return new DaZhongCarTyre();
    }
}
