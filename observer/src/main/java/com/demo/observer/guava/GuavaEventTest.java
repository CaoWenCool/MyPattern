package com.demo.observer.guava;

import com.google.common.eventbus.EventBus;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:49
 * @version: V1.0
 * @detail:
 **/
public class GuavaEventTest {
    public static void main(String[] args) {
        //消息总线
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);
        eventBus.post("Tom");

        //从Stuts到SpringMVC的升级
        //因为Struts面向的类，而SpringMVC面向的是方法

        //前两者面向的是类，Guava面向的是方法


        //能够轻松落地观察模式的一种解决方案
        //MQ

    }
}
