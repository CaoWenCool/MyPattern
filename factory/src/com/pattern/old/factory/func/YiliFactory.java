package com.pattern.old.factory.func;

import com.pattern.old.factory.entity.Milk;
import com.pattern.old.factory.entity.YiLi;

/**
 * @author: admin
 * @create: 2019/3/5
 * @update: 9:31
 * @version: V1.0
 * @detail:
 **/
public class YiliFactory implements Factory{
    @Override
    public Milk getMilk() {
        return new YiLi();
    }
}
