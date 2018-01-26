package com.sinsuren.user.management.utils.logging;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by surender.s on 26/01/18.
 */
@Aspect
@Slf4j
public class LogExectuionTimeAspect {
    private static final String LOG_MESSAGE_FORMAT = "%s.%s execution time %d ms";

    @Pointcut("execution(@com.sinsuren.user.management.utils.logging.LogExecutionTime * *(..))")
    public void isAnnotated(){}

    @Around("isAnnotated")
    public Object logTimeOfMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object retValue = proceedingJoinPoint.proceed();
        stopWatch.stop();
        logExecutionTime(proceedingJoinPoint, stopWatch);
        return retValue;
    }

    private void logExecutionTime(ProceedingJoinPoint joinPoint, StopWatch stopWatch) {
        String logMessage = String.format(LOG_MESSAGE_FORMAT, joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), stopWatch.getTime());
        log.info(logMessage);
    }
}
