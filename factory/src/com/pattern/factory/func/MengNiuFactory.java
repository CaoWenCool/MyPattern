package com.pattern.factory.func;

import com.pattern.factory.entity.MengNiu;
import com.pattern.factory.entity.Milk;

/**
 * @author: admin
 * @create: 2019/3/5
 * @update: 9:29
 * @version: V1.0
 * @detail:
 **/
public class MengNiuFactory implements Factory{
    @Override
    public Milk getMilk() {
        return new MengNiu();
    }
}
