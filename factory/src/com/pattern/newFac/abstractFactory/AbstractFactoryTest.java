package com.pattern.newFac.abstractFactory;

/**
 * @author: admin
 * @create: 2019/3/25
 * @update: 12:09
 * @version: V1.0
 * @detail:
 **/
public class AbstractFactoryTest {
    public static void main(String[] args) {
        JiLiCarFactory jiLiCarFactory = new JiLiCarFactory();
        jiLiCarFactory.installCarDoor().installCarDoor();
        jiLiCarFactory.installCarTyre().instalTyre();
    }
}
