package com.milan.Aop_Demo.Aspect;

import com.milan.Aop_Demo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLogin {

    @Around("execution(* com.milan.Aop_Demo.Service.*.getFortune(..)))")
    public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {

        //print method we are advising on
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("\n ----> Executing @Around on method" + methodName);

        //get begin timestamp
        //long startTime = System.currentTimeMillis();

        long startTime = System.nanoTime();

        //now, let's execute method, joinPoint will handle targetMethod and .proceed will execute
        Object result = null;

        try {
            result = joinPoint.proceed();
        }catch (Exception e) {

            //log exception
            System.out.println(e.getMessage());

            //Rethrow exception
            throw e;

            //give user custom message
            //result = "Don't worry. We are arriving in 2 minutes";
        }

        //get end time stamp
        //long endTime = System.currentTimeMillis();
        long endTime = System.nanoTime();

        //compute duration and display
        long duration = endTime - startTime;

        System.out.println("\n ---> Time taken: " + duration + " nano seconds");

        return result;
    }


    @After("execution(* com.milan.Aop_Demo.Dao.AccountDAO.findAccounts(..))")
    public void afterFinally(JoinPoint joinPoint) {
        //point out which method we are advising on
        String methodName = joinPoint.getSignature().getName();
        System.out.println("\n ----> Executing @AfterFinally.. Always executed just like finally block" + methodName);
    }

    @AfterThrowing(pointcut = "execution(* com.milan.Aop_Demo.Dao.AccountDAO.findAccounts(..))",
                    throwing = "theException")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable theException) {

        //point out which method we are advising on
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Executing @AfterThrowing advice on method: " + methodName);

        System.out.println("\n ->>>> Exception is: " + theException);
    }


    //Add new advice for @AfterReturning on findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.milan.Aop_Demo.Dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, List<Account> result) {

        //print out which method we are advising on
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("\n -----> Executing @AfterReturning on method " + methodName);

        //modify the "result" list before returning it to method call of program: add,update,remove
        //calling program will get the new data
//        if(!result.isEmpty()) {
//            Account tempAccount = result.get(0);
//            tempAccount.setName("Mbappe Lama");
//        }

        //call method to uppercase
        convertAccountToUpper(result);

        //print out the results on method call
        System.out.println("\n -----> Result : " + result);
    }

    private void convertAccountToUpper(List<Account> result) {

        for(Account tempAccount : result) {
            String upperAccountName = tempAccount.getName().toUpperCase();

            tempAccount.setName(upperAccountName);
        }
    }


    @Before("com.milan.Aop_Demo.Aspect.AopExpressionsUtility.noGetterSetterForDaoPackage()()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n ---> Executing @Before Advice on method...");

        //display method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("MethodSignature: " + methodSignature);

        //display method arguments

        //Get args
        Object[] args = theJoinPoint.getArgs();

        //loop through those args
        for(Object tempArgs : args){
            System.out.println(tempArgs);

            if(tempArgs instanceof Account){
                //downcast and print Account specific stuff
                Account tempAccount = (Account) tempArgs;
                System.out.println("Account Name: " + tempAccount.getName());
                System.out.println("Account Balance: " + tempAccount.getBalance());
            }
        }
    }
}
