package com.demo.adapter.loginadapter.v1;

import com.demo.adapter.loginadapter.v1.service.SinginForThirdService;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:19
 * @version: V1.0
 * @detail:
 **/
public class SiginForThirdServiceTest {
    public static void main(String[] args) {
        SinginForThirdService service = new SinginForThirdService();
        service.login("test","123456");
        service.loginForQQ("12234");
        service.loginForWeChat("qeqweqwe");
    }
}
