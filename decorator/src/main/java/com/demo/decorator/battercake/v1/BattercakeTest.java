package com.demo.decorator.battercake.v1;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:08
 * @version: V1.0
 * @detail:
 **/
public class BattercakeTest {
    public static void main(String[] args) {
        Battercake battercake = new Battercake();
        System.out.println(battercake.getMsg()+",总价格"+battercake.getPrice());

        BattercakeWithEgg battercakeWithEgg = new BattercakeWithEgg();
        System.out.println(battercakeWithEgg.getMsg()+",总价格"+battercakeWithEgg.getPrice());

        BattercakeWithEggAndSausage battercakeWithEggAndSausage = new BattercakeWithEggAndSausage();
        System.out.println(battercakeWithEggAndSausage.getMsg()+"，总价格"+battercakeWithEggAndSausage.getPrice());
    }
}
