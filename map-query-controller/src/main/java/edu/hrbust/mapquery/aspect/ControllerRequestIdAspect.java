package edu.hrbust.mapquery.aspect;

import edu.hrbust.common.utils.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.config.Order;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@Order(-10)
public class ControllerRequestIdAspect {
    @Pointcut("execution(public * edu.hrbust.mapquery.controller..*.*(..))")
    public void controllerPoint() {
    }

    @Around("controllerPoint()")
    public Object doControllerPointAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String requestId = RequestUtils.generateRequestId();
        MDC.put(RequestUtils.REQUEST_ID_KEY, requestId);
        Object result = null;
        try {
            result = joinPoint.proceed();
        } finally {
            MDC.remove(RequestUtils.REQUEST_ID_KEY);
        }
        return result;
    }
}