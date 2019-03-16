package com.pattern.old.factory.func;

import com.pattern.old.factory.entity.MengNiu;
import com.pattern.old.factory.entity.Milk;

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
