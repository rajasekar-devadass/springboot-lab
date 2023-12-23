package com.lab;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AspectDemo {
    private static final Logger logger = LoggerFactory.getLogger(AspectDemo.class);

    @Before(value = "execution(* com.lab.StudentController.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.trace("Before method:" + joinPoint.getSignature());
        logger.trace(Arrays.toString(joinPoint.getArgs()));
    }
}
