package com.milan.Aop_Demo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ApiAnalytics {

    //reusing point cut and applying to another advice
    @Before("com.milan.Aop_Demo.Aspect.AopExpressionsUtility.noGetterSetterForDaoPackage()")
    public void apiAnalytics(){
        System.out.println("\n ---> Performing Api Analytics on method...");
    }
}
