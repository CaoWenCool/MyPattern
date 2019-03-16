package com.pattern.old.factory.test;

import com.pattern.old.factory.func.Factory;
import com.pattern.old.factory.func.SanLuFactory;

/**
 * @author: admin
 * @create: 2019/3/5
 * @update: 9:32
 * @version: V1.0
 * @detail:
 **/
public class FactoryTest {


    public static void main(String[] args) {

        //货币三家
        //配置，可能回配置错

        Factory factory = new SanLuFactory();
        System.out.println(factory.getMilk().getName());
    }
}
