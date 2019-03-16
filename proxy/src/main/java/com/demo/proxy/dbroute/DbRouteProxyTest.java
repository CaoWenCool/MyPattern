package com.demo.proxy.dbroute;

import com.demo.proxy.dbroute.proxy.OrderServiceDynamicProxy;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: admin
 * @create: 2019/3/15
 * @update: 15:06
 * @version: V1.0
 * @detail:
 **/
public class DbRouteProxyTest {
    public static void main(String[] args) {
        try{
            Order order = new Order();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2017/12/01");
            order.setCreateTime(date.getTime());

            IOrderService orderService = (IOrderService) new OrderServiceDynamicProxy().getInstance(new OrderService());
            orderService.createOrder(order);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
