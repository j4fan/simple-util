package com.j4fan.simpleutils.aop;

import com.j4fan.simpleutils.service.TokenService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckTokenAspect {

    @Autowired
    TokenService tokenService;

    @Pointcut("@annotation(com.j4fan.simpleutils.annotations.CheckToken)")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void after(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Long userId = (Long) args[0];
        String token = (String) args[1];
        tokenService.checkToken(userId, token);
    }
}
