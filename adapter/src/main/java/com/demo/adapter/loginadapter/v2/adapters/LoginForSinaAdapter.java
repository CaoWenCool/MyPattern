package com.demo.adapter.loginadapter.v2.adapters;

import com.demo.adapter.loginadapter.ResultMsg;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:21
 * @version: V1.0
 * @detail:
 **/
public class LoginForSinaAdapter implements LoginAdapter{
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForSinaAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
