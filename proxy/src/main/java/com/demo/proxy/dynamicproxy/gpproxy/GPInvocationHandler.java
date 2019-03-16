package com.demo.proxy.dynamicproxy.gpproxy;

import java.lang.reflect.Method;

/**
 * @author: admin
 * @create: 2019/3/15
 * @update: 15:28
 * @version: V1.0
 * @detail:
 **/
public interface GPInvocationHandler {

    public Object invoke(Object proxy, Method method,Object[] args) throws Throwable;
}
