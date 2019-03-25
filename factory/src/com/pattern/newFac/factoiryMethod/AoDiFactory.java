package com.pattern.newFac.factoiryMethod;

import com.pattern.newFac.AoDiCar;
import com.pattern.newFac.Car;

/**
 * @author: admin
 * @create: 2019/3/25
 * @update: 12:11
 * @version: V1.0
 * @detail:
 **/
public class AoDiFactory implements CarFactory{
    @Override
    public Car install() {
        return new AoDiCar();
    }
}
