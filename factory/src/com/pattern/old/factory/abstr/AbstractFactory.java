package com.pattern.old.factory.abstr;

import com.pattern.old.factory.entity.Milk;

/**
 * @author: admin
 * @create: 2019/3/5
 * @update: 8:52
 * @version: V1.0
 * @detail: 抽象工厂是用户的主入口再Spring中
 * 应用得最为广泛得一种设计模式
 **/
public abstract class AbstractFactory {
    //公共得逻辑
    //方便于统一管理

    public  abstract Milk getMengNiu();

    public abstract Milk getYili();

    public abstract  Milk getTeLunSu();

    public abstract Milk getSanlu();
}
