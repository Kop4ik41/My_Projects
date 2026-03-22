package ru.rut_miit.lab1cdispring.Interceptors;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import ru.rut_miit.lab1cdispring.Component.AppStart;


@Component
@Aspect
@Log4j2
public class ProfileInterceptor {
    @Pointcut("within(ru.rut_miit.lab1cdispring.Component.AppStart)")
    public void logInfo() {
    };

    @After("logInfo()")
    public void logMethodCall(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        log.info("название метода: " + methodName);
        AppStart appStart = (AppStart) jp.getTarget();
        String serviceName = appStart.getServiceName();
        log.info("название метода сортировки: " + serviceName);

        appStart.getIntegerList().forEach(log::info);
    }

    @Around("logInfo()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        log.info(joinPoint.getSignature() + " выполнен за " + executionTime + "мс");
        return proceed;
    }


}
