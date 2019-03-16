package com.demo.proxy.simpleproxy;

import com.demo.proxy.simpleproxy.Subject;

/**
 * @author: admin
 * @create: 2019/3/15
 * @update: 14:29
 * @version: V1.0
 * @detail:
 **/
public class Proxy implements Subject{

    public Subject subject;

    public Proxy(Subject subject){
        this.subject = subject;
    }

    @Override
    public void request() {
        before();
        subject.request();
        after();
    }

    public void before(){
        System.out.println("called before request()");
    }

    public void after(){
        System.out.println("called after request()");
    }
}
