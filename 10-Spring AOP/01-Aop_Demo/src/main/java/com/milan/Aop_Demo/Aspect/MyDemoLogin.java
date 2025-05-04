package com.milan.Aop_Demo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogin {

    //this is where we add all our related advices for logging

    //calling accountDao method only
    //@Before("execution(public void com.milan.Aop_Demo.Dao.AccountDAO.addAccount())")

    //Call any method starting with add
    //@Before("execution(public void add*())")

    //match on method add() with return type of any
    //@Before("execution(* add*())")

    //match on method add() with the parameter type Account only. || .. means match any parameters more than 2
    //@Before("execution(* add*(com.milan.Aop_Demo.Account,..))")

    //match methods with any parameters 0-many
    //narrow pointcut expression to our package
    //@Before("execution(* com.milan.Aop_Demo..add*(..))")

    //return to any method of this Dao Package
    // first * -> return type, then package, second * -> class, third * -> method, .. -> any params
    @Before("execution(* com.milan.Aop_Demo.Dao.*.*(..))")

    //@Before("execution(public void update())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n ---> Executing @Before Advice on method...");
    }



}
