package com.demo.proxy.dbroute.db;

/**
 * @author: admin
 * @create: 2019/3/15
 * @update: 15:09
 * @version: V1.0
 * @detail:
 **/
public class DynamicDataSourceEntity {

    public final static String DEFAULT_SOURCE = null;

    public final static ThreadLocal<String> local = new ThreadLocal<String>();

    private DynamicDataSourceEntity(){

    }

    public static String get(){
        return local.get();
    }

    public static void restore(){
        local.set(DEFAULT_SOURCE);
    }

    public static void set(String source){
        local.set(source);
    }

    public static void set(int year){
        local.set("DB_"+year);
    }
}
