package com.demo.singleton.lazy;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:01
 * @version: V1.0
 * @detail:懒汉式单例
 * 这种形式兼顾饿汉式单的内存浪费，也兼顾synchronized性能问题
 * 完美地屏蔽了这两个缺点
 **/
public class LazyInnerClassSingleton {
    //默认使用LazyInnerClassGeneral地时候，会先初始化内部类
    //如果没有使用的话，内部类时不加载的

    private LazyInnerClassSingleton(){
        if(LazyHolder.LAZY != null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    //static 是为了是单例的内存空间共享
    //保证这个方法不会被重写，重载
    public static final LazyInnerClassSingleton getInstance(){
        //在返回结果以前，一定会先加载内部类
        return LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
}
