package com.demo.summarize.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:32
 * @version: V1.0
 * @detail:
 **/
//声明这是一个组件
@Component
//声明这是一个切面 aspect
@Aspect
@Slf4j
public class ArgsAspect {
    //配置切入点，该方法无方法体，主要为方便同类中其他的方法使用此处配置的切入点
    @Pointcut("execution(* com.demo.summarize.aop.service..*(..))")
    public void  aspect(){}

    //配置前置通知，拦截返回值 cn.ysh.studio.spring.mvc.bean.User的方法
    @Before("execution(com.demo.summarize.aop.model.Member com.demo.summarize.aop.service..*(..))")
    public void beforeReturnUser(JoinPoint joinPoint){
        log.info("beforeReturnUser"+joinPoint);
    }

    //配置前置通知，拦截参数返回值为 cn.ysh.studio.spring.mvc.bean.User方法
    @Before("execution(* com.demo.summarize.aop.service..*(com.demo.summarize.aop.model.Member))")
    public void beforeArgUser(JoinPoint joinPoint){
        log.info("beforeArgUser" + joinPoint);
    }

    //配置前置通知，拦截含有long类型的参数的方法，并将参数值注入到当前方法的形参id中
    @Before("aspect()&&args(id)")
    public void beforeArgId(JoinPoint joinPoint,long id){
        log.info("beforeArgId"+joinPoint+"\tID"+id);
    }
}
