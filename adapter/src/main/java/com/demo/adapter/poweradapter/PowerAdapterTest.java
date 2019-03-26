package com.demo.adapter.poweradapter;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:17
 * @version: V1.0
 * @detail:
 **/
public class PowerAdapterTest {

    public static void main(String[] args) {
        DC5 dc5 = new PowerAdapter(new AC220());
        dc5.outputDC5V();
    }
}
