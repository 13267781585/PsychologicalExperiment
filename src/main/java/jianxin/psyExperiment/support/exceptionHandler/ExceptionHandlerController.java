package jianxin.psyExperiment.support.exceptionHandler;

import jianxin.psyExperiment.support.returnEntity.ServerReturnObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
@ResponseBody
public class ExceptionHandlerController {
    public final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);
    @ExceptionHandler(value = Exception.class)
    public ServerReturnObject handlerException(Exception e)
    {
        LOGGER.error(e.getMessage());
        return ServerReturnObject.createErrorByMessage(e.getMessage());
    }
}
