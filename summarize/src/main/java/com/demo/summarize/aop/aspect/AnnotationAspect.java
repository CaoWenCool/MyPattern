package com.demo.summarize.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:31
 * @version: V1.0
 * @detail:
 **/
//声明这是一个组件
@Component
//声明这是一个切面  Bean
@Aspect
@Slf4j
public class AnnotationAspect {
    //配置切入点，该方法无方法体，主要为方便同类中其他方法使用此处配置的切入点
    @Pointcut("execution(* com.demo.summarize.aop.service..*(..))")
    public void aspect(){}

    /**
     * 配置前置通知，使用方法aspect()上注册的切入点
     * 同时接收JoinPoint切入点对象，可以没有该参数
     * @param joinPoint
     */
    @Before("aspect()")
    public void before(JoinPoint joinPoint){
        log.info("before 通知"+ joinPoint);
    }

    //配置后置通知，使用方法再aspect()上注册的切入点
    @After("aspect()")
    public void after(JoinPoint joinPoint){
        log.info("after通知"+joinPoint);
    }

    //配置环绕通知，使用aspect()上注册的切入点
    @Around("aspect()")
    public void arount(JoinPoint joinPoint){
        long start = System.currentTimeMillis();
        try{
            ((ProceedingJoinPoint)joinPoint).proceed();
            long end = System.currentTimeMillis();
            log.info("around通知"+joinPoint+"\tUse time:"+(end - start)+"ms!");
        }catch (Throwable a){
            long end = System.currentTimeMillis();
            log.info("around 通知"+ joinPoint + "\tUse time" + (end - start)+"ms with exception:"+ a.getMessage());
        }
    }

    //配置后置返回通知，使用再方法aspect()上注册的切入点
    @AfterReturning("aspect()")
    public void afterReturn(JoinPoint joinPoint){
        log.info("afterReturn 通知"+joinPoint);
    }

    //配置抛出异常通知后通知，使用方法aspect()上注册的切入点
    @AfterThrowing(pointcut = "aspect()",throwing = "e")
    public void afterThrow(JoinPoint joinPoint,Exception e){
        log.info("afterThrow通知"+joinPoint+"\t"+e.getMessage());
    }

}
