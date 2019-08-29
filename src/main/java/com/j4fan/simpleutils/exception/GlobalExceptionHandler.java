package com.j4fan.simpleutils.exception;

import com.j4fan.simpleutils.common.Result;
import com.j4fan.simpleutils.common.ResultGenerator;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result errorHandlerOverJson(Exception exception) {
        String errorMessage = exception.getMessage();
        return ResultGenerator.genFailResult(errorMessage);
    }

}
