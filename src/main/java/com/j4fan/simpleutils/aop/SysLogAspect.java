package com.j4fan.simpleutils.aop;

import com.j4fan.simpleutils.annotations.SysLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class SysLogAspect {

    @Pointcut("@annotation(com.j4fan.simpleutils.annotations.SysLog)")
    public void pointCut(){
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        printLog(point);

        return result;
    }

    private void printLog(ProceedingJoinPoint proceedingJoinPoint){
        MethodSignature methodSignature = (MethodSignature)proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();

        SysLog sysLog = method.getAnnotation(SysLog.class);
        System.out.println("日志描述:"+sysLog.value());
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = methodSignature.getName();

        Object[] objects = proceedingJoinPoint.getArgs();
        StringBuffer sb = new StringBuffer();
        for(Object object:objects){
            sb.append(object.toString());
        }
        System.out.println("className:"+className);
        System.out.println("methodName:"+methodName);
        System.out.println("请求参数:"+sb.toString());

    }

}
