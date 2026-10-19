package org.example.Logging;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Component
@Aspect
@Order(1)
public class SecurityAspect {
    private Logger logger=Logger.getLogger(SecurityAspect.class.getName());
    @Around("@annotation(ToLog)")
    public Object secure(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName=joinPoint.getSignature().getName();
        Object [] args=joinPoint.getArgs();
        logger.info("Securing method:"+methodName +"with args: "+ Arrays.asList(args));
        Object result=joinPoint.proceed();
        logger.info("Executed method:"+methodName +"with res"+ result);
        return "returnedBySecurity->"+result;
    }
}
