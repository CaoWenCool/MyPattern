package com.demo.delegate.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:30
 * @version: V1.0
 * @detail:
 **/
public class Leader implements IEmployee{
    private Map<String,IEmployee> targets = new HashMap<String,IEmployee>();

    @Override
    public void doing(String command) {
        targets.get(command).doing(command);
    }

    public Leader(){
        targets.put("加密",new IEmployeeA());
        targets.put("解密",new IEmployeeB());
    }
}
