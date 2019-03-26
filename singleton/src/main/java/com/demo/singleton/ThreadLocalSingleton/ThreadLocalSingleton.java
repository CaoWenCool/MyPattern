package com.demo.singleton.ThreadLocalSingleton;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:04
 * @version: V1.0
 * @detail:
 **/
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
            new ThreadLocal<ThreadLocalSingleton>(){
                @Override
                protected ThreadLocalSingleton initialValue (){
                    return new ThreadLocalSingleton();
                }
            };

    private ThreadLocalSingleton(){

    }

    public static ThreadLocalSingleton getInstance(){
        return threadLocalInstance.get();
    }
}
