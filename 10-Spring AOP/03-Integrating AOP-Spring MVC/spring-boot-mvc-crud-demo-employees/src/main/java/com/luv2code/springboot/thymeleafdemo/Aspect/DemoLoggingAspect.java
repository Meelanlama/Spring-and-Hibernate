package com.luv2code.springboot.thymeleafdemo.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    //setup logger
    private Logger myLogger = Logger.getLogger(this.getClass().getName());

    //setup pointcut declarations
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    //for all package
    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    //Add @Before advice

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        //display method we are calling
        String methodName = joinPoint.getSignature().toShortString();
        myLogger.info("---> In @Before: calling method: " + methodName);

        //display arguments to method
        //get arguments
        Object[] args = joinPoint.getArgs();

        //loop and display args
        for (Object tempArg : args) {
            myLogger.info("---> Method Arguments " + tempArg);
        }
    }

    //Add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){

        //display method we are returning from
        //display method we are calling
        String methodName = theJoinPoint.getSignature().toShortString();
        myLogger.info("---> In @After returning, calling method: " + methodName);

        //display data returned
        myLogger.info("theResult: " + theResult);
    }
}
