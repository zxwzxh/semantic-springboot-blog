package com.zxw.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制器异常处理器
 * @author zxw
 * @create 2020-12-23 8:47
 */
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception e) throws Throwable {
        //打印URL和异常类
        log.error("Request URL : {}, Exception : {}", request.getRequestURL(), e.getClass());
        //如果抛出的异常上面已经有了@ResponseStatus注解，就抛出这个异常
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        ModelAndView mv = new ModelAndView();
        //向mv中添加url和exception
        mv.addObject("url", request.getRequestURL());
        mv.addObject("exception", e);
        //设置要返回的视图
        mv.setViewName("error/error");
        return mv;
    }
}
