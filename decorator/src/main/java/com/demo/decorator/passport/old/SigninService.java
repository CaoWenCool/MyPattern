package com.demo.decorator.passport.old;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:04
 * @version: V1.0
 * @detail:
 **/
public class SigninService implements ISiginService{
    @Override
    public ResultMsg regist(String username, String password) {
        return new ResultMsg(200,"注册成功",new Member());
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public ResultMsg login(String username, String password) {
        return null;
    }
}
