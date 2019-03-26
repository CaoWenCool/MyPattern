package com.demo.observer.events.core;

import java.lang.reflect.Method;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:46
 * @version: V1.0
 * @detail:
 **/
public class Event { //事件源，事件是由谁发起的保存起来
    private Object source;
    //事件触发，要通知谁
    private Object target;
    //事件的触发，要做什么动作，回调
    private Method callback;
    //事件的名称，触发的是什么事件
    private String trigger;
    //事件触发的时间
    private long time;

    public Event(Object target, Method callback){
        this.target  = target;
        this.callback = callback;
    }

    public Event setSource(Object source){
        this.source = source;
        return this;
    }

    public Event setTime(long time){
        this.time = time;
        return this;
    }

    public long getTime(){
        return time;
    }

    public Object getTarget(){
        return target;
    }

    public Method getCallback(){
        return callback;
    }


    @Override
    public String toString() {
        return "Event{" + "\n" +
                "\tsource=" + source.getClass() + ",\n" +
                "\ttarget=" + target.getClass() + ",\n" +
                "\tcallback=" + callback + ",\n" +
                "\ttrigger='" + trigger + "',\n" +
                "\ttime=" + time + "'\n" +
                '}';
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

}
