package com.demo.proxy.staticproxy;

import com.demo.proxy.Person;

/**
 * @author: admin
 * @create: 2019/3/15
 * @update: 11:54
 * @version: V1.0
 * @detail:
 **/
public class Father implements Person{

    private Son person;

    public Father(Son person){
        this.person  = person;
    }
    @Override
    public void findLove() {
        System.out.println("父亲物色对象");
        this.person.findLove();
        System.out.println("双方父母同意，确立关系");
    }

    public void findJob(){

    }
}
