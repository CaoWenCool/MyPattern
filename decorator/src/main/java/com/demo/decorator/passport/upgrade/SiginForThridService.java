package com.demo.decorator.passport.upgrade;

import com.demo.decorator.passport.old.ISiginService;
import com.demo.decorator.passport.old.ResultMsg;
import com.demo.decorator.passport.old.SigninService;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:05
 * @version: V1.0
 * @detail:
 **/
public class SiginForThridService implements ISiginForThirdService{
    private ISiginService siginService;

    public SiginForThridService(SigninService signinService) {
        this.siginService = signinService;
    }

    @Override
    public ResultMsg regist(String username, String password) {
        return siginService.regist(username,password);
    }

    @Override
    public ResultMsg login(String username, String password) {
        return siginService.login(username,password);
    }

    @Override
    public ResultMsg loginForQQ(String id) {
        return new ResultMsg(200,id,"qq");
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return new ResultMsg(200,id,"微信");
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return new ResultMsg(200,token,"token");
    }

    @Override
    public ResultMsg loginForPhone(String telPhone, String code) {
        return new ResultMsg(200,telPhone,telPhone+code);
    }

    @Override
    public ResultMsg loginForRegist(String username, String passport) {
        return new ResultMsg(200,username,username+passport);
    }
}
