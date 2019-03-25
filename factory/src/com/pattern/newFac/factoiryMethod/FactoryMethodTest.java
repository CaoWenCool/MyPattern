package com.pattern.newFac.factoiryMethod;

import com.pattern.newFac.Car;

/**
 * @author: admin
 * @create: 2019/3/25
 * @update: 12:16
 * @version: V1.0
 * @detail:
 **/
public class FactoryMethodTest {
    public static void main(String[] args) {
        CarFactory carFactory = new JiLiFactory();
        Car car = carFactory.install();
        System.out.print(car.getName());
        carFactory = new DaZhongFactory();
        car = carFactory.install();
        System.out.print(car.getName());
    }
}
