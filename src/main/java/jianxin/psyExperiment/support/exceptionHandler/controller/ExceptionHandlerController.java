package jianxin.psyExperiment.support.exceptionHandler.controller;

import jianxin.psyExperiment.support.exceptionHandler.entity.ServerReturnObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionHandlerController {
    @ExceptionHandler(value = Exception.class)
    public ServerReturnObject handlerException(Exception e)
    {
        return ServerReturnObject.createErrorByMessage(e.getMessage());
    }
}
