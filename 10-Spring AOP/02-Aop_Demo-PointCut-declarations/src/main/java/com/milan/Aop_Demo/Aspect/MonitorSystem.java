package com.milan.Aop_Demo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MonitorSystem {

    @Before("com.milan.Aop_Demo.Aspect.AopExpressionsUtility.noGetterSetterForDaoPackage()()")
    public void monitorSystem(){
        System.out.println("\n ---> Performing System Analytics on method...");
    }
}
