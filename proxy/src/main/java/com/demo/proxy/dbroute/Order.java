package com.demo.proxy.dbroute;

/**
 * @author: admin
 * @create: 2019/3/15
 * @update: 14:34
 * @version: V1.0
 * @detail:
 **/
public class Order {

    private String id;
    private Object orderInfo;
    //订单创建时间进行按年分库
    private Long createTime;

    public Object getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



}
