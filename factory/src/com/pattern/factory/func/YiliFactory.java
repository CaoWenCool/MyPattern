package com.pattern.factory.func;

import com.pattern.factory.entity.Milk;
import com.pattern.factory.entity.YiLi;

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
