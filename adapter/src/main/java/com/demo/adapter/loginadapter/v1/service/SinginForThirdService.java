package com.demo.adapter.loginadapter.v1.service;

import com.demo.adapter.loginadapter.ResultMsg;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:19
 * @version: V1.0
 * @detail:
 **/
public class SinginForThirdService extends SiginService{
    public ResultMsg loginForQQ(String openId){
        //1\openId是全局唯一的，我们可以把它当做是一个用户名加长
        //2、密码默认为QQ_EMPTY
        //3、注册

        //调用原来的登录方法

        return loginForRegist(openId,null);
    }

    public ResultMsg loginForWeChat(String openId){
        return null;
    }

    public ResultMsg loginForToken(String token){
        //通过token拿到用户信息，然后在重新登录一次
        return null;

    }

    public ResultMsg loginForTelPhone(String phone,String code){
        return null;
    }

    public ResultMsg loginForRegist(String username,String password){
        super.regist(username,null);
        return super.login(username,null);

    }
}
