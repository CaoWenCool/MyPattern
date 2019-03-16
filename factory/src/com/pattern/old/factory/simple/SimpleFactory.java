package com.pattern.old.factory.simple;

import com.pattern.old.factory.entity.MengNiu;
import com.pattern.old.factory.entity.Milk;
import com.pattern.old.factory.entity.TenLunSu;

/**
 * @author: admin
 * @create: 2019/3/5
 * @update: 9:34
 * @version: V1.0
 * @detail:
 **/
public class SimpleFactory {

    public Milk getMilk(String name){
        if("特仑苏".equals(name)){
            return new TenLunSu();
        }else if("蒙牛".equals(name)){
            return new MengNiu();
        }else {
            System.out.println("不能生产你所需要的产品");
            return  null;
        }
    }
}
