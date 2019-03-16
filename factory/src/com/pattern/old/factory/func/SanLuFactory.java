package com.pattern.old.factory.func;

import com.pattern.old.factory.entity.Milk;
import com.pattern.old.factory.entity.SanLu;

/**
 * @author: admin
 * @create: 2019/3/5
 * @update: 9:30
 * @version: V1.0
 * @detail:
 **/
public class SanLuFactory implements Factory{
    @Override
    public Milk getMilk() {
        return new SanLu();
    }
}
