package com.demo.proxy.staticproxy;

import com.demo.proxy.Person;

/**
 * @author: admin
 * @create: 2019/3/15
 * @update: 11:54
 * @version: V1.0
 * @detail:
 **/
public class Son implements Person{


    @Override
    public void findLove() {
        System.out.println("儿子要求：白富美");
    }

    public void findJob(){

    }

    public void eat(){
        
    }
}
