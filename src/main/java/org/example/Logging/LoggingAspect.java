package org.example.Logging;

import lombok.Getter;
import lombok.Setter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.Models.Comments;
import org.example.Services.CommentService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Getter
@Setter
@Component
@Aspect
@Order(2)
public class LoggingAspect {
    private Logger logger= Logger.getLogger(LoggingAspect.class.getName());
    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodeName=joinPoint.getSignature().getName();
        Object [] args=joinPoint.getArgs();
        logger.info(methodeName+" method with parameters:"+ Arrays.asList(args)+" will execute");
        Comments comments=new Comments();
        comments.setAuthor("Rusty");
        comments.setText("Great");
        Object [] newArgs={comments};
        Object returnByMethod=joinPoint.proceed(newArgs);
        logger.info(methodeName+" method has executed");
        return "returnByLogger->"+returnByMethod;
    }
}
