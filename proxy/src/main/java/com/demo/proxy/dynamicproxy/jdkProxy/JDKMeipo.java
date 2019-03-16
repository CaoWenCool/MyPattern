package com.demo.proxy.dynamicproxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 曹文 on 2019/3/16.
 */
public class JDKMeipo implements InvocationHandler{
    private Object target;

    public Object getInstance(Object person)throws Exception{
        this.target = person;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        Object obj  = method.invoke(this.target,args);
        after();
        return null;
    }

    private void before(){
        System.out.println("我是媒婆，我要给你找对象，现在已经确认需求");
        System.out.println("开始物色");
    }

    private void after(){
        System.out.println("OK 的话，准备办事");
    }
}
