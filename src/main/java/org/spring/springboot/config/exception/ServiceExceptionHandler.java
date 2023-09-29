package org.spring.springboot.config.exception;

import org.spring.springboot.common.enums.BusiCodeEnum;
import org.spring.springboot.common.exception.ServiceException;
import org.spring.springboot.common.result.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-29 23:26
 */
@ControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Result<?>> handler(HttpServletResponse response, ServiceException e) {
        return ResponseEntity.status(response.getStatus()).body(
                Result.buildServiceFailure(BusiCodeEnum.getBusiCodeEnum(e.getCode()), e.getMessage()));
    }
}
