package com.pattern.factory.test;

import com.pattern.factory.abstr.MilkFactory;

/**
 * @author: admin
 * @create: 2019/3/5
 * @update: 8:57
 * @version: V1.0
 * @detail:
 **/
public class AbstractFactoryTest {
    public static void main(String[] args) {
        MilkFactory factory = new MilkFactory();

        //对于用户而言，更加简单了
        //用户只有选择得权力了，保证了程序得健壮性

        System.out.println(factory.getMengNiu().getName());
    }
}
