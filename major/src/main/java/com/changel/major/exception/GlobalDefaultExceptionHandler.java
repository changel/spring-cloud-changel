package com.changel.major.exception;

import com.changel.major.support.ResponseEntity;
import com.changel.major.support.ResponseEntityUtils;
import com.changel.major.support.ResultEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;


/**
 * describe: 全局的异常捕获
 *
 * @author changel
 * @date 2019/08/04
 */
@RestControllerAdvice
@Slf4j
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(value = { IllegalArgumentException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity illegalArgumentExceptionException(IllegalArgumentException ex) {
        log.debug("Bad Request",ex);
        return ResponseEntityUtils.buildResponseData(ResultEnums.BAD_REQUEST_ERROR);
    }

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity noHandlerFoundException(Exception ex) {
        log.debug("Not Found",ex);
        return  ResponseEntityUtils.buildResponseData(ResultEnums.NOT_FOUND_ERROR);
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity unknownException(Exception ex) {
        log.debug("Internal Server Error",ex);
        return ResponseEntityUtils.buildResponseData(ResultEnums.ERROR);
    }
}
