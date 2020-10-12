package com.zhu.bootsecurity.exceptionhand;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author zpm
 * @version 1.0
 */
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(AccessDeniedException.class)
    public String accessDefine(){
        return "redirect:/403.jsp";
    }

    @ExceptionHandler(Exception.class)
    public String otherException(){
        return "redirect:/500.jsp";
    }
}
