package com.demo.adapter.loginadapter.v2.adapters;

import com.demo.adapter.loginadapter.ResultMsg;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:23
 * @version: V1.0
 * @detail:
 **/
public interface RegistAdapter {

    boolean support(Object adapter);

    ResultMsg login(String id, Object adapter);
}
