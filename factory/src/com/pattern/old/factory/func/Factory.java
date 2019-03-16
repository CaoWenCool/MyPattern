package com.pattern.old.factory.func;

import com.pattern.old.factory.entity.Milk;

/**
 * @author: admin
 * @create: 2019/3/5
 * @update: 9:04
 * @version: V1.0
 * @detail: 工厂模型
 **/
public interface Factory {

    //工厂必然具有生产产品得技能，统一得产品出口
    Milk getMilk();
}
