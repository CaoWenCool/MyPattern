package com.demo.singleton.hungry;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:01
 * @version: V1.0
 * @detail:
 **/
public class HungryStaticSingleton {
    private static final HungryStaticSingleton hungryStaticSingleton;

    static {
        hungryStaticSingleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton(){}

    public static HungryStaticSingleton getInstance(){
        return hungryStaticSingleton;
    }
}
