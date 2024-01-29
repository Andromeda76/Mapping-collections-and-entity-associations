package com.example.springdatawthboot.API;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class AspectConfig {
    private static Logger logger = LoggerFactory.getLogger(AspectConfig.class);

    @Before("execution(* com.example.springdatawthboot.Controller..*(..))")
    public void simpleBeforeAdvice(JoinPoint joinPoint){
        var signature = (MethodSignature) joinPoint.getSignature();

        System.out.println(Arrays.toString(signature.getParameterNames()));
    }


    @After("execution(* com.example.springdatawthboot.Controller..*(..))")
    public void simpleAfterAdvice(JoinPoint joinPoint){
        var signature = (MethodSignature) joinPoint.getSignature();

        System.out.println(signature.getReturnType());

    }

//    @Around("execution(* com.example.springdatawthboot.Controller.TraversController.*(..)))")
//    public void simpleAroundAdvice(JoinPoint joinPoint){
//        var signature = (MethodSignature) joinPoint.getSignature();
//        logger.info("Executing AspectConfig with the name (Around): \n ", signature.getName());
//    }

}
