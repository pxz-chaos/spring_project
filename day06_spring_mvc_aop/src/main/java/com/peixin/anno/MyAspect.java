package com.peixin.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类：内部有增强方法
 */

@Component("myAspect")
@Aspect//标注当前MyAspect是一个切面
public class MyAspect {


    //配置前置增强
//    @Before(value = "execution(* com.peixin.anno.*.*(..))")
    @Before("pointcut()")
    public void before() {
        System.out.println("前置增强");
    }


    public void afterRetuning() {
        System.out.println("后置增强");
    }

    //    @Around(value = "execution(* com.peixin.anno.*.*(..))")
    //ProceedingJoinPoint 正在执行的连接点-->切点
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕强增强");
        //切点方法
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕后增强");
        return proceed;
    }


    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("异常抛出增强...");
    }


    //    @After(value = "execution(* com.peixin.anno.*.*(..))")
    @After("pointcut()")
    //不管你抛不抛异常 该方法都会被执行
    public void after() {
        System.out.println("最终增强...");
    }


    @Pointcut(value = "execution(* com.peixin.anno.*.*(..))")
    //定义切点表达式
    public void pointcut() {
    }
}
