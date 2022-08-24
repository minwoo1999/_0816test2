package com.example._0816test2.AOP;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* com.example._0816test2..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{

        long start =System.currentTimeMillis();

        System.out.println("Start:"+joinPoint.toString());

        try{
            return joinPoint.proceed();
        }
        finally {
            long finish =System.currentTimeMillis();
            long timeMs =finish-start;
            System.out.println("End:"+joinPoint.toString()+""+timeMs+"ms");

        }
    }
}
