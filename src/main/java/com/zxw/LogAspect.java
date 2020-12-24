package com.zxw;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;

/**
 * 日志处理切面，记录
 *  请求URL
 *  访问者ip
 *  调用方法
 *  参数args
 *  返回内容
 * @author zxw
 * @create 2020-12-23 9:24
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    /**
     * 定义一个切入点表达式
     * 这里代表切入所有控制器的所有方法
     */
    @Pointcut("execution(* com.zxw.controller.*.*(..))")
    public void log() {

    }

    @Around("log()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //获取URL和IP
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String URL = request.getRequestURL().toString();
        String IP = request.getRemoteAddr();
        //获取方法名和参数列表
        Signature signature = pjp.getSignature();
        String classMethod = signature.getDeclaringTypeName() + "." + signature.getName();
        Object[] args = pjp.getArgs();
        //日志记录RequestLog
        log.info("Request : {}", new RequestLog(URL, IP, classMethod, args));
        //获取返回值
        Object result = pjp.proceed(args);
        //日志记录结果
        log.info("Result : {}", result);
        return result;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class RequestLog {
        private String URL;
        private String IP;
        private String classMethod;
        private Object[] args;
    }
}
