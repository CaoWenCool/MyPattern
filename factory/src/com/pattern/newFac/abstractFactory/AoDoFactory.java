package com.pattern.newFac.abstractFactory;

/**
 * @author: admin
 * @create: 2019/3/25
 * @update: 12:05
 * @version: V1.0
 * @detail:
 **/
public class AoDoFactory implements CarFactory{
    @Override
    public CarDoor installCarDoor() {
        return new AoDiCarDoor();
    }

    @Override
    public CarTyre installCarTyre() {
        return new AoDiCarTyre();
    }
}
