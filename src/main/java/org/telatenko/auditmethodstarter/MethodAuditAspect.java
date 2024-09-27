package org.telatenko.auditmethodstarter;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MethodAuditAspect {

    @Around("execution(* org.telatenko..*(..))")
    public Object auditMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Aspect is triggered for method: {}", joinPoint.getSignature().getName());

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        String className = signature.getDeclaringType().getSimpleName();

        Object[] args = joinPoint.getArgs();
        log.info("Method {} in class {} called with arguments: {}", methodName, className, args);

        try {
            Object result = joinPoint.proceed();

            log.info("Method {} in class {} returned: {}", methodName, className, result);

            return result;
        } catch (Throwable e) {

            log.error("Method {} in class {} threw an exception: {}", methodName, className, e.getMessage(), e);
            throw e;
        }
    }
}
