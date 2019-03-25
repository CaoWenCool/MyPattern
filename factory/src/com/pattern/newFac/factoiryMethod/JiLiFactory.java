package com.pattern.newFac.factoiryMethod;

import com.pattern.newFac.Car;
import com.pattern.newFac.JiLiCar;

/**
 * @author: admin
 * @create: 2019/3/25
 * @update: 12:16
 * @version: V1.0
 * @detail:
 **/
public class JiLiFactory implements CarFactory{
    @Override
    public Car install() {
        return new JiLiCar();
    }
}
