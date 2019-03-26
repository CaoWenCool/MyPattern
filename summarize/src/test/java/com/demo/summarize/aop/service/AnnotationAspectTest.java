package com.demo.summarize.aop.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:36
 * @version: V1.0
 * @detail:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationAspectTest {

    @Autowired
    MemberService memberService;

    @Test
    public void testGet(){
        memberService.get();
    }
}
