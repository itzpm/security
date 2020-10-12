package com.zhu.controller.advice;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author ZPM
 */
@ControllerAdvice
public class ControllerExceptionAdvice {

    /**
     * 只有出现AccessDeniedException异常才调转403.jsp页面
     * @return str
     */
    @ExceptionHandler(AccessDeniedException.class)
    public String exceptionAdvice() {
        return "forward:/403.jsp";
    }


    @ExceptionHandler(Exception.class)
    public String runtimeExceptionAdvice() {
        return "forward:/500.jsp";
    }

}
