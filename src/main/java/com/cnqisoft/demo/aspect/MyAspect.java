package com.cnqisoft.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Around("execution(* com.cnqisoft.demo.controller.UserController.*(..))")
    public Object HandleControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("before execution");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("arg: " + arg);
        }
        Object object = joinPoint.proceed();
        System.out.println("after execution");
        return object;
    }


}
