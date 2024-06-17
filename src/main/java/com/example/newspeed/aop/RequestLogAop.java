package com.example.newspeed.aop;


import jakarta.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;

import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Slf4j(topic = "RequestLogAop")
@Aspect
@Component
public class RequestLogAop {

    @Pointcut("execution(public * com.example.newspeed.controller.*.*(..))")
    public void Controller() {
    }


    @After("Controller()")
    public void logRequest(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            log.info("Request URL: "  + request.getRequestURL().toString() + "HTTP Method: " + request.getMethod());
    }
}

