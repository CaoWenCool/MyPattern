package com.demo.adapter.loginadapter.v1.service;

import com.demo.adapter.loginadapter.Member;
import com.demo.adapter.loginadapter.ResultMsg;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:18
 * @version: V1.0
 * @detail:
 **/
public class SiginService {
    public ResultMsg regist(String username,String password){
        return new ResultMsg(200,"注册成功",new Member());
    }

    public ResultMsg login(String username, String password){
        return null;
    }
}
