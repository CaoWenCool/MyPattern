package com.demo.decorator.battercake.v2;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:11
 * @version: V1.0
 * @detail:
 **/
public class BattercakeTest {
    public static void main(String[] args) {
        Battercake battercake;

        battercake = new BaseBattercake();
        battercake = new EggDecorator(battercake);

        battercake = new SausageDecorator(battercake);
        battercake = new SausageDecorator(battercake);
        battercake = new SausageDecorator(battercake);
        battercake = new SausageDecorator(battercake);

        //跟静态代理最大区别就是职责不同
        //静态代理比一定要满足is-a的关系
        //静态代理会做功能增强，同一个职责变得不一样

        //装饰器更多考虑是扩展

        System.out.println(battercake.getMsg()+"，总价格"+battercake.getPrice());

    }
}
