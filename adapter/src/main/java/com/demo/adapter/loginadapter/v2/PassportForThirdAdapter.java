package com.demo.adapter.loginadapter.v2;

import com.demo.adapter.loginadapter.ResultMsg;
import com.demo.adapter.loginadapter.v1.service.SiginService;
import com.demo.adapter.loginadapter.v2.adapters.*;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:24
 * @version: V1.0
 * @detail:
 **/
public class PassportForThirdAdapter extends SiginService implements IPassportForThird{
    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWeChat(String id) {
        return processLogin(id, LoginForWeChatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token, LoginForTokenAdapter.class);
    }

    @Override
    public ResultMsg loginForTelPhone(String telPhone, String code) {
        return processLogin(telPhone, LoginForTelAdapter.class);
    }

    @Override
    public ResultMsg loginForRegist(String username, String passport) {
        super.regist(username,passport);
        return super.login(username,passport);
    }

    private ResultMsg processLogin(String key, Class<? extends LoginAdapter> clazz){
        try{

            //适配器接不一定要实现接口
            LoginAdapter adapter = clazz.newInstance();

            //判断传过来的适配器是否能处理指定的逻辑
            if(adapter.support(adapter)){
                return adapter.login(key,adapter);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
