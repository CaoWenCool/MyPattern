package com.pattern.old.factory.test;

import com.pattern.old.factory.simple.SimpleFactory;

/**
 * @author: admin
 * @create: 2019/3/5
 * @update: 9:36
 * @version: V1.0
 * @detail:
 **/
public class SimpleFactoryTest {

    public static void main(String[] args) {
        //这个new 的过程实际上一个比较复杂的故丛横

        //小作坊式的生产模式
        //yoghurt本身不需要再关心生产的过程，而只需要关心这个结果

        SimpleFactory factory = new SimpleFactory();

        //把用户的需求告诉工厂
        //创建产品的过程隐藏了，对于用户而且完全不清楚式怎么生产的
        System.out.println(factory.getMilk("AAA"));

    }
}
