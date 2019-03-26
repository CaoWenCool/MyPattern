package com.demo.decorator.passport.upgrade;

import com.demo.decorator.passport.old.ISiginService;
import com.demo.decorator.passport.old.ResultMsg;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:04
 * @version: V1.0
 * @detail:
 **/
public interface ISiginForThirdService extends ISiginService {
    /**
     * qq登录
     * @param id
     * @return
     */
    ResultMsg loginForQQ(String id);

    /**
     * 微信登录
     * @param id
     * @return
     */
    ResultMsg loginForWechat(String id);

    /**
     * token登录
     * @param token
     * @return
     */
    ResultMsg loginForToken(String token);

    /**
     * 手机登录
     * @param telPhone
     * @param code
     * @return
     */
    ResultMsg loginForPhone(String telPhone,String code);

    /**
     * 注册后登录
     * @param username
     * @param passport
     * @return
     */
    ResultMsg loginForRegist(String username,String passport);
}
