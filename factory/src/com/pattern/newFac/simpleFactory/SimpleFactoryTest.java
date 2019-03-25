package com.pattern.newFac.simpleFactory;

import com.pattern.newFac.Car;
import com.pattern.newFac.JiLiCar;

/**
 * @author: admin
 * @create: 2019/3/25
 * @update: 12:18
 * @version: V1.0
 * @detail:
 **/
public class SimpleFactoryTest {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car car = carFactory.install(JiLiCar.class);
        System.out.print(car.getName());

        CarFactory factory = new CarFactory();
        Car car1 = factory.installTwo("com.pattern.newFac.AoDiCar");
        System.out.print(car1.getName());
    }
}
