package com.demo.singleton.hungry;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:00
 * @version: V1.0
 * @detail:它是类加载的时候就立即初始化，并且创建单例对象
 * 优点：没有加任何锁、执行效率高
 * 在用户体验上来说，比懒汉式更好
 *
 * 缺点：类加载时就初始化，不管你用还是不用，都占着空间
 * 浪费了内存，有可能白白占据着内存
 *
 * 绝对线程安全，在线程还没有出现以前就是实例化了，不存在访问安全问题
 **/
public class HungrySingleton {

    //先静态、后动态
    //先属性、后方法
    //先上后下

    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
