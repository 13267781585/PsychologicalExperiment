package jianxin.psyExperiment.support.exceptionHandler;

import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
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
