package com.demo.proxy.dynamicproxy.gpproxy;

import com.demo.proxy.Person;
import com.demo.proxy.dynamicproxy.jdkProxy.Girl;

/**
 * Created by 曹文 on 2019/3/16.
 */
public class GPProxyTest {

    public static void main(String[] args) {
        try{
            //JDK动态代理的实现原理
            Person obj = (Person) new GPMeipo().getInstance(new Girl());
            System.out.println(obj.getClass());
            obj.findLove();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
