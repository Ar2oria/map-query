package edu.hrbust.mapquery.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(0)
@Slf4j
@Aspect
@Component
public class ServiceLogAspect  {
    @Pointcut("execution(public *  edu.hrbust.mapquery.service..*ServiceImpl.*(..))")
    public void servicePoint() {
        //切点
    }

    @Around("servicePoint()")
    public Object doServiceAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = null;
        try {
            Object[] params = joinPoint.getArgs();
            log.info("Service层 className={}, methodName={}, params={}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), Arrays.toString(params));
            result = joinPoint.proceed();
        }
        finally {
            log.info("Service层 耗时={}(ms), className={}, methodName={}, result={}", System.currentTimeMillis() - startTime, joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), result);
        }
        return result;
    }
}