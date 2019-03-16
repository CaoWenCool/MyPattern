package com.demo.proxy.simpleproxy;

/**
 * @author: admin
 * @create: 2019/3/15
 * @update: 14:32
 * @version: V1.0
 * @detail:
 **/
public class Client {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new RealSubject());

        proxy.request();
    }
}
