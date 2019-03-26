package com.demo.delegate.simple;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:33
 * @version: V1.0
 * @detail:
 **/
public class DelegateTest {
    public static void main(String[] args) {
        //客户请求BOSS，委派者Leader，被委派者target
        //委派者要持有被委派者的引用
        //代理模式注重的是过程，委派模式注重的是结果
        //策略模式注重的可扩展（外部扩展），委派模式注重内部的灵活和复用
        //委派的核心：就是分发、调度、派遣

        //委派模式：就是静态代理和策略模式的一种特殊组合

        new Boss().commond("加密",new Leader());
    }
}
