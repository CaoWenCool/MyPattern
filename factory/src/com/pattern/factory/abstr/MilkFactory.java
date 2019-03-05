package com.pattern.factory.abstr;

import com.pattern.factory.entity.*;

/**
 * @author: admin
 * @create: 2019/3/5
 * @update: 8:57
 * @version: V1.0
 * @detail:
 **/
public class MilkFactory extends AbstractFactory{

    @Override
    public Milk getMengNiu() {
        return new MengNiu();
    }

    @Override
    public Milk getYili() {
        return new YiLi();
    }

    @Override
    public Milk getTeLunSu() {
        return new TenLunSu();
    }

    @Override
    public Milk getSanlu() {
        return new SanLu();
    }
}
