package com.demo.proxy.dbroute;

/**
 * @author: admin
 * @create: 2019/3/15
 * @update: 14:35
 * @version: V1.0
 * @detail:
 **/
public class OrderDao {
    public int insert(Order order){
        System.out.println("OrderDao 创建order成功");
        return  1;
    }
}
