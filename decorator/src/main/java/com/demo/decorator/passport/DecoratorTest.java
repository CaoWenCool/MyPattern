package com.demo.decorator.passport;

import com.demo.decorator.passport.old.SigninService;
import com.demo.decorator.passport.upgrade.ISiginForThirdService;
import com.demo.decorator.passport.upgrade.SiginForThridService;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:02
 * @version: V1.0
 * @detail:
 **/
public class DecoratorTest { public static void main(String[] args) {
    //满足is-a的关系
    ISiginForThirdService siginForThirdService = new SiginForThridService(new SigninService());
    siginForThirdService.loginForQQ("sadfadfasf");
}
}
