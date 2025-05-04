package com.milan.Aop_Demo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressionsUtility {

    @Pointcut("execution(* com.milan.Aop_Demo.Dao.*.*(..))")
    public void forDaoPackage(){
    }

    //create a pointcut for getter methods
    @Pointcut("execution(* com.milan.Aop_Demo.Dao.*.get*(..))")
    public void forGetterMethod(){
    }

    //create a pointcut for setter methods
    @Pointcut("execution(* com.milan.Aop_Demo.Dao.*.set*(..))")
    public void forSetterMethod(){
    }

    //create a pointcut to include package methods but exclude getters and setters method of package
    //this pointcut won't include the advice for getter and setter for the package.
    //Getter setter will be executed but advice will be excluded for it
    @Pointcut("forDaoPackage() && !(forGetterMethod() || forSetterMethod())")
    public void noGetterSetterForDaoPackage(){
    }
}
