package com.oracle.workshop.model.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

/**
 * Created with IntelliJ IDEA for the Oracle Coding Workshops.
 * User: crbirlad
 */
@Aspect
public class Logging {
    //get log4j handler
    private static final Logger logger = Logger.getLogger(Logging.class);

    /**
     * intercept visit calls
     */
    @Around("execution(* com.oracle.workshop.model.visitor.ItemVisitor.visit(..))")
    public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object retVal = joinPoint.proceed();

        stopWatch.stop();

        StringBuilder logMessage = getLogString(joinPoint, stopWatch);
        logger.info(logMessage.toString());

        return retVal;
    }

    private StringBuilder getLogString(ProceedingJoinPoint joinPoint, StopWatch stopWatch) {
        StringBuilder logMessage = new StringBuilder();
        logMessage.append(joinPoint.getTarget().getClass().getName());
        logMessage.append(".");
        logMessage.append(joinPoint.getSignature().getName());
        logMessage.append("(");
        // append args
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            logMessage.append(args[i]).append(",");
        }
        if (args.length > 0) {
            logMessage.deleteCharAt(logMessage.length() - 1);
        }

        logMessage.append(")");
        logMessage.append(" execution time: ");
        logMessage.append(stopWatch.getTotalTimeMillis());
        logMessage.append(" ms");

        return logMessage;
    }

    /**
     * This is the method which I would like to execute * if there is an exception raised.
     */
    public void AfterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("There has been an exception: " + ex.toString());
    }
}
