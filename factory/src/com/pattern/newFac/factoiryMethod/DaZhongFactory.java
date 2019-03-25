package com.pattern.newFac.factoiryMethod;

import com.pattern.newFac.Car;
import com.pattern.newFac.DaZhongCar;

/**
 * @author: admin
 * @create: 2019/3/25
 * @update: 12:15
 * @version: V1.0
 * @detail:
 **/
public class DaZhongFactory implements CarFactory{
    @Override
    public Car install() {
        return new DaZhongCar();
    }
}
