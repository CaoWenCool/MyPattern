package com.pattern.newFac.abstractFactory;

/**
 * @author: admin
 * @create: 2019/3/25
 * @update: 12:08
 * @version: V1.0
 * @detail:
 **/
public class JiLiCarFactory implements CarFactory{
    @Override
    public CarDoor installCarDoor() {
        return new JiLiCarDoor();
    }

    @Override
    public CarTyre installCarTyre() {
        return new JiLiCarTyre();
    }
}
