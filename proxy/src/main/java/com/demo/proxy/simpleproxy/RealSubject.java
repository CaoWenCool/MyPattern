package com.demo.proxy.simpleproxy;

/**
 * @author: admin
 * @create: 2019/3/15
 * @update: 14:24
 * @version: V1.0
 * @detail:
 **/
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("real service is called");
    }
}
