package com.demo.delegate.simple;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:31
 * @version: V1.0
 * @detail:
 **/
public class IEmployeeB implements IEmployee{
    @Override
    public void doing(String command) {
        System.out.println("我是员工B，我现在开始干"+command +"工作");
    }
}
