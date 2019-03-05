package com.pattern.factory.func;

import com.pattern.factory.entity.Milk;
import com.pattern.factory.entity.TenLunSu;

/**
 * @author: admin
 * @create: 2019/3/5
 * @update: 9:30
 * @version: V1.0
 * @detail:
 **/
public class TelunSuFactory implements Factory{
    @Override
    public Milk getMilk() {
        return new TenLunSu();
    }
}
