package com.demo.proxy.dbroute.proxy;


import com.demo.proxy.dbroute.db.DynamicDataSourceEntity;
import com.demo.proxy.dynamicproxy.gpproxy.GPClassLoader;
import com.demo.proxy.dynamicproxy.gpproxy.GPInvocationHandler;
import com.demo.proxy.dynamicproxy.gpproxy.GPProxy;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: admin
 * @create: 2019/3/15
 * @update: 15:13
 * @version: V1.0
 * @detail:
 **/
public class OrderServiceDynamicProxy implements GPInvocationHandler{

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    Object proxyObj;

    public Object getInstance(Object proxyObj){
        this.proxyObj = proxyObj;
        Class<?> clazz = proxyObj.getClass();
        return GPProxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }

    private void after(){
        System.out.println("Proxy after method");

        //还原默认的数据源
        DynamicDataSourceEntity.restore();
    }

    private void before(Object target){
        try{
            //进行数据源的切换
            System.out.println("Proxy before method");

            //约定优于配置
            Long time = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
            Integer dbPouter = Integer.valueOf(yearFormat.format(new Date(time)));
            System.out.println("静态代理类自动分配到【DB"+dbPouter + "】数据源处理数据");

            DynamicDataSourceEntity.set(dbPouter);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
