package com.demo.proxy.dbroute;


/**
 * @author: admin
 * @create: 2019/3/15
 * @update: 14:36
 * @version: V1.0
 * @detail:
 **/
public class OrderService implements IOrderService{
    private OrderDao orderDao;
    public OrderService(){
        //我们使用Spring应该是自动注入的
        //我们为了使用方便，在构造方法中将orderDao直接初始化了
        orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService调用orderDao创建订单");
        return orderDao.insert(order);
    }
}
