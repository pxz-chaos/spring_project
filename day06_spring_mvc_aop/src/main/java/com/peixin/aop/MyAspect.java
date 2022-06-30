package com.peixin.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类：内部有增强方法
 */
public class MyAspect {
    public void before() {
        System.out.println("前置增强");
    }

    public void afterRetuning() {
        System.out.println("后置增强");
    }

    //ProceedingJoinPoint 正在执行的连接点-->切点
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕强增强");
        //切点方法
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕后增强");
        return proceed;
    }


    public void afterThrowing() {
        System.out.println("异常抛出增强...");
    }

    //不管你抛不抛异常 该方法都会被执行
    public void after() {
        System.out.println("最终增强...");
    }
}
