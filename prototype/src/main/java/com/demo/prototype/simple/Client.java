package com.demo.prototype.simple;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:51
 * @version: V1.0
 * @detail:
 **/
public class Client {
    private Prototype prototype;

    public Client(Prototype prototype){
        this.prototype = prototype;
    }

    public Prototype startClone(Prototype prototype){
        return prototype.clone();
    }
}
