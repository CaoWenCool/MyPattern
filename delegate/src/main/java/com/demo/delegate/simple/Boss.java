package com.demo.delegate.simple;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:30
 * @version: V1.0
 * @detail:
 **/
public class Boss {
    public void commond(String commond,Leader leader){
        leader.doing(commond);
    }
}
