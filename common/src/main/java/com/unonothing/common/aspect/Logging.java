package com.unonothing.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

    private static final Logger log = LoggerFactory.getLogger(Logging.class);

    @Before("execution(* com.unonothing.*.*.*.*(..))")
    public void LogBeforeMethods(JoinPoint joinPoint){
        if (log.isTraceEnabled()){
            log.trace("Entering >>> " + joinPoint.getSignature());
        }
    }
}
