package com.demo.prototype.deep;

import java.io.Serializable;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:53
 * @version: V1.0
 * @detail:
 **/
public class JinGuBang implements Serializable {
    public float h = 100;
    public float d = 10;

    public void big(){
        this.d *= 2;
        this.h *= 2;
    }

    public void small(){
        this.d /=2;
        this.h /=2;
    }
}
