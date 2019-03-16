package com.demo.proxy.dynamicproxy.jdkProxy;

import java.lang.reflect.Method;

/**
 * Created by 曹文 on 2019/3/16.
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        try{

            Object obj = new JDKMeipo().getInstance(new Girl());
            Method method = obj.getClass().getMethod("findLove",null);
            method.invoke(obj);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
