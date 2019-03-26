package com.demo.observer.events.mouseevent;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:47
 * @version: V1.0
 * @detail:
 **/
public interface MouseEventType {
    //单机
    String ON_CLICK = "click";
    //双击
    String ON_DOUBLE_CLICK = "doubleClick";
    //弹起
    String ON_UP = "up";
    //按下
    String ON_DOWN = "down";
    //移动
    String ON_MOVE = "move";
    //滚动
    String ON_WHEEL = "wheel";
    //悬停
    String ON_OVER = "over";
    //失去焦点
    String ON_BLUR = "blur";
    //获取焦点
    String ON_FOCUS = "focus";

}
