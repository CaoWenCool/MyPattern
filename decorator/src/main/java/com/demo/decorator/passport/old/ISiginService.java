package com.demo.decorator.passport.old;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:03
 * @version: V1.0
 * @detail:
 **/
public interface ISiginService {
    ResultMsg regist(String username,String password);

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    ResultMsg login(String username,String password);
}
