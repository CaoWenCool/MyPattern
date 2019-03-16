package com.demo.proxy.staticproxy;

/**
 * @author: admin
 * @create: 2019/3/15
 * @update: 11:58
 * @version: V1.0
 * @detail:
 **/
public class FatherProxyTest {
    public static void main(String[] args) {
        Father father = new Father(new Son());

        father.findLove();

    }
}
