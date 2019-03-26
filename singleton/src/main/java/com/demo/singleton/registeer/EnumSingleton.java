package com.demo.singleton.registeer;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:03
 * @version: V1.0
 * @detail:
 **/
public enum EnumSingleton {
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
