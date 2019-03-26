package com.demo.singleton.registeer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:02
 * @version: V1.0
 * @detail:Spring 中的做法，就是用这种注册式单例
 **/
public class ContainerSingleton {
    private ContainerSingleton(){}

    private static Map<String,Object> ioc = new ConcurrentHashMap<>();
    public static Object getInstance(String className){
        synchronized (ioc){
            if(!ioc.containsKey(className)){
                Object obj = null;
                try{
                    obj = Class.forName(className).newInstance();
                    ioc.put(className,obj);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return obj;
            }else{
                return ioc.get(className);
            }
        }
    }

}
