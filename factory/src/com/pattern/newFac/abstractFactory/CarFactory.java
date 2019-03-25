package com.pattern.newFac.abstractFactory;

/**
 * @author: admin
 * @create: 2019/3/25
 * @update: 12:04
 * @version: V1.0
 * @detail:
 **/
public interface CarFactory {
    /**
     * 车门
     * @return
     */
    CarDoor installCarDoor();

    /**
     * 车胎
     * @return
     */
    CarTyre installCarTyre();
}
