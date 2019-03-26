package com.demo.adapter.loginadapter.v2;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:26
 * @version: V1.0
 * @detail:
 **/
public class PassportTest {
    public static void main(String[] args) {
        IPassportForThird passportForThird = new PassportForThirdAdapter();
        passportForThird.loginForQQ("11");
    }

}
